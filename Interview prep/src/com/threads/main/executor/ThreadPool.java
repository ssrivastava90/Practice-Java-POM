package com.threads.main.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private int size;
    private boolean initialized;
    BlockingQueue<Runnable> blockingQueue;
    List<Thread> threadList;
    Runnable POISON_PILL = new Runnable() {
        @Override
        public void run() {
            //Do nothing;
        }
    };

    public ThreadPool(int size){
        this.size = size;
        blockingQueue = new ArrayBlockingQueue<Runnable>(size);
        threadList = new ArrayList<>(size);

        init();
    }

    private void init() {
        initialized = true;
        for(int i = 0; i < size; i++){
            ExtendedThread extendedThread = new ExtendedThread();
            threadList.add(extendedThread);
            extendedThread.start();
        }

    }

    public void submit(Runnable runnable){
        blockingQueue.add(runnable);
    }

    public void shutDown(){
        initialized = false;
        for(int i = 0; i < size; i++) {
            if (blockingQueue.size() == 5){
                break;
            }
            blockingQueue.add(POISON_PILL);
        }
    }

    private class ExtendedThread extends Thread {

        @Override
        public void run() {
            while (initialized){
                try {
                    Runnable run = blockingQueue.take();
                    run.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
