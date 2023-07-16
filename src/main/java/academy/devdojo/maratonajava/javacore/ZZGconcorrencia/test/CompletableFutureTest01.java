package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
//        searchPricesAsyncFuture(storeService);
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to search prices %d%n.", (end - start));
        StoreService.shutdown();
    }

    private static void searchPricesAsyncFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        Future<Double> pryceAsyncFuture1 = storeService.getPryceAsyncFuture("Store 1");
        Future<Double> pryceAsyncFuture2 = storeService.getPryceAsyncFuture("Store 2");
        Future<Double> pryceAsyncFuture3 = storeService.getPryceAsyncFuture("Store 3");
        Future<Double> pryceAsyncFuture4 = storeService.getPryceAsyncFuture("Store 4");
        try {
            System.out.println(pryceAsyncFuture1.get());
            System.out.println(pryceAsyncFuture2.get());
            System.out.println(pryceAsyncFuture3.get());
            System.out.println(pryceAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to search prices %d%n.", (end - start));
        StoreService.shutdown();
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> pryceAsyncFuture1 = storeService.getPryceAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pryceAsyncFuture2 = storeService.getPryceAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pryceAsyncFuture3 = storeService.getPryceAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pryceAsyncFuture4 = storeService.getPryceAsyncCompletableFuture("Store 4");

        System.out.println(pryceAsyncFuture1.join());
        System.out.println(pryceAsyncFuture2.join());
        System.out.println(pryceAsyncFuture3.join());
        System.out.println(pryceAsyncFuture4.join());
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to search prices %d%n.", (end - start));
    }
}
