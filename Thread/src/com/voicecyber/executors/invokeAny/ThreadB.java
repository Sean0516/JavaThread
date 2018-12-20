package com.voicecyber.executors.invokeAny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class ThreadB implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread().isInterrupted() == false) {
                    System.out.println("hello world ThreadB");

                }else {
                    System.out.println("抛出中断异常");
                    throw new InterruptedException("线程中断了");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thread B";
    }

    public static void main(String[] args) {

        try {
            List<Callable<String>> list = new ArrayList(2);
            list.add(new ThreadA());
            list.add(new ThreadB());
            ExecutorService executorService = Executors.newCachedThreadPool();
            String o = executorService.invokeAny(list);
            System.out.println("获得返回值 ："+o);
            System.out.println("------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end ");
    }
}
