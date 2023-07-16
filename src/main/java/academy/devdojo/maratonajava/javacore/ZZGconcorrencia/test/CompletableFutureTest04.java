package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.model.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);

    }

    private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync)
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEachOrdered(System.out::println);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        List<CompletableFuture<String>> completableFutureList = stores.stream()
                .map(store -> CompletableFuture.supplyAsync(() -> service.getPriceSync(store)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .toList();

        completableFutureList.stream()
                .map(CompletableFuture::join)
                .forEachOrdered(System.out::println);
    }
}
