package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.model.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);

    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(() -> service.getPriceSync(store)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, System.currentTimeMillis() - start)))
                .toArray(CompletableFuture[]::new);

        // ALL OF: Retorna um novo completable future
        //CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFutures);
        // ANY OF: Considerado finalizado quando UMA das tarefas estiver terminada
        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(completableFutures);
        completableFuture.join();
        System.out.printf("Finished? %b%n", completableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Tempo de execução: %d ms.%n", end - start);
    }
}
