package com.threads.main;

import java.util.concurrent.Callable;

public class CallabableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ", Callable IMPL ");
        return 10;
    }
}
