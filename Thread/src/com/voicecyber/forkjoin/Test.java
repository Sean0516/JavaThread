package com.voicecyber.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
//        CountTask countTask=new CountTask(1,100);
//        Future<Integer> future= forkJoinPool.submit(countTask);
//        try {
//            System.out.println( "result:"+ future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        ShowMessageTask showMessageTask=new ShowMessageTask(1,10);
        forkJoinPool.execute(showMessageTask);
        forkJoinPool.shutdown();
        try {
            forkJoinPool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (showMessageTask.isCompletedNormally()){
            System.out.println(showMessageTask.getException().getCause());
        }
    }
}
