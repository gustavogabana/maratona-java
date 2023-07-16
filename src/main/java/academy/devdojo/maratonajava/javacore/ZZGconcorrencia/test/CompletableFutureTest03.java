package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest03 {

    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(storeServiceDeprecated);
    }
    // THREAD FACTORY: troca o comportamento das Threads
    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeServiceDeprecated) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        long start = System.currentTimeMillis();

        List<Double> prices = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(s), executor))
                .map(CompletableFuture::join)
                .toList();

        System.out.println(prices);
        long end = System.currentTimeMillis();
        System.out.printf("Tempo: %d", (end - start));
        executor.shutdown();
    }
}
