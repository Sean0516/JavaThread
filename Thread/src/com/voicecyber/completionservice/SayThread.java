package com.voicecyber.completionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Sean on 2018/12/4
 *
 * @author Sean
 */
public class SayThread implements Callable<String> {
    private String name;
    private Long sleepTime;


    public SayThread(String name, Long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+ "hello "+ name);
        Thread.sleep(sleepTime);
        return name;
    }

    public static void main(String[] args) {
        SayThread sean = new SayThread("sean", 1000L);
        SayThread master = new SayThread("master", 3000L);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
        executorCompletionService.submit(sean);
        executorCompletionService.submit(master);

        for (int i = 0; i <2 ; i++) {
            System.out.println("等待打印线程  "+i +" 的返回值");
            try {
                System.out.println("线程返回值为："+executorCompletionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();

            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
