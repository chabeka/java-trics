package com.kindia.solia.newsInJava8.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 *
 */
public class SupplyAsyncDemo {

    /**
     * with runnable only
     * is executed in global Thread
     *
     * @return
     */

    public String supplyAsync() throws ExecutionException, InterruptedException {

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                try {
                    // global Thread name
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5000);
                    return "person";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        return completableFuture.get();
    }

    /**
     * is executed in custom Thread
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public String runAsyncWithExecutor() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                try {
                    // global Thread name
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5000);
                    return "person";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executor);
        return completableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsyncDemo runAsyncDemo = new SupplyAsyncDemo();
        runAsyncDemo.supplyAsync();
        runAsyncDemo.runAsyncWithExecutor();

        long timeToWait = 10;
        long timeToPass = 0;
        while (true) {
            Thread.sleep(10000);
            timeToPass = timeToWait + 1/60;
            if(timeToPass > timeToWait) {
                break;
            }
        }
    }
}
