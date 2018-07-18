package com.voicecyber.thradpool;

import java.util.concurrent.*;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        CustomThreadPool threadPoolExecutor=new CustomThreadPool(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), r -> {
            Thread thread=new Thread(r);
            thread.setDaemon(true);
            return thread;
        }, new ThreadPoolExecutor.AbortPolicy());
        ThreadGetString threadGetString=new ThreadGetString();
        ThreadGetString threadGetString1=new ThreadGetString();
        Future<String> submit = threadPoolExecutor.submit(threadGetString);
        Future<String> submit1 = threadPoolExecutor.submit(threadGetString1);
        try {
            String str1 = submit.get();
            String str2=submit1.get();
            System.out.println("str1  "+str1 +"_____str2"+str2 );
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}
