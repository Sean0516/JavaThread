package com.voicecyber.completablefuture;

import java.util.concurrent.*;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class CompletableFutureSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 指定线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                (r -> {
                    Thread thread = new Thread(r);
                    thread.setName("Test Pool Name" + thread.getName());
                    thread.setDaemon(true);
                    return thread;
                }));
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true){
                throw new RuntimeException("test exception ");
            }
            return 4 * 4;
        }).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return 0;
        })
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "num is: " + str).thenAccept(System.out::println);
        completableFuture.get();
    }
}
