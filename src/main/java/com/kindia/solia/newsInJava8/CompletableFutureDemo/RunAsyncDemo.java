package com.kindia.solia.newsInJava8.CompletableFutureDemo;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 */
public class RunAsyncDemo {

    /**
     * with runnable only
     * is executed in global Thread
     * @return
     */

    public Void runAsync() throws ExecutionException, InterruptedException {
        Runnable runnabe = new Runnable() {
            @Override
            public void run() {
                try {
                    // global Thread name
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("get personne");
            }
        };
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnabe);
        return completableFuture.get();
    }

    /**
     * is executed in custom Thread
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Void runAsyncWithExecutor() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        Runnable runnabe = new Runnable() {
            @Override
            public void run() {
                try {
                    // custom Thread name
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("get personne");
            }
        };
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnabe, executor);
        return completableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        runAsyncDemo.runAsync();
        runAsyncDemo.runAsyncWithExecutor();
    }
}
