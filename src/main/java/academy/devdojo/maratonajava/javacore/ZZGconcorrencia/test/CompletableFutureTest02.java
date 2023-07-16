package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest02 {

    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        long start = System.currentTimeMillis();

        List<Double> prices = stores.parallelStream()
                .map(storeService::getPryceAsyncCompletableFuture)
                .map(CompletableFuture::join)
                .toList();

        List<CompletableFuture<Double>> list = stores.stream().map(storeService::getPryceAsyncCompletableFuture).toList();
        List<Double> doubles = list.stream().map(CompletableFuture::join).toList();

        System.out.println(doubles);

        System.out.println(prices);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to search prices %d%n.", (end - start));
        
    }
}
