package com.threads.main;

import com.threads.main.executor.ThreadPool;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread1Exp {


    public static void main(String args[]) throws Exception {
        //This executes in current thread
        RunnableImpl runnable = new RunnableImpl();
        runnable.run();

        //Execute in different thread.
        Thread t1 = new Thread(runnable);
        t1.run(); //again executed in current thread

        t1.start(); //Creates a new thread , and is ready for scheduling.

        //Callable.
        CallabableThread callabableThread = new CallabableThread();
        int result  = callabableThread.call(); // Executes in same thread.

        System.out.println(result);

        //Using custom thread pool
        ThreadPool threadPool = new ThreadPool(5);
        threadPool.submit(runnable);
//        threadPool.submit(runnable);
//        threadPool.submit(runnable);
//        threadPool.submit(runnable);
//        threadPool.submit(runnable);

        threadPool.shutDown();

        //Using Executor Service.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(runnable);
        Future<Integer> futureWhichWillGetAInteger = executorService.submit(callabableThread);

        System.out.println("Waiting for result");
        Integer result1 = futureWhichWillGetAInteger.get();
        System.out.println(result1);
        executorService.shutdown();

        //For Go-jec, Since defualt queue is of infinite length, need not check current submit size.
    }
}
