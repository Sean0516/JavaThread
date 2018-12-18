package com.voicecyber.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Sean on 2018/7/18
 *
 * @author Sean
 */
public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService=Executors.newCachedThreadPool();
        executorService=Executors.newSingleThreadExecutor();
        executorService=Executors.newScheduledThreadPool(10);
    }

}
