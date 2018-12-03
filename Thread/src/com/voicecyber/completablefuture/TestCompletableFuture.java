package com.voicecyber.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class TestCompletableFuture implements Runnable {
    private CompletableFuture<Integer> completableFuture;

    public TestCompletableFuture(CompletableFuture<Integer> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            i = completableFuture.get() * completableFuture.get(); //当 CompletableFuture 中无数据传输的时候，线程会阻塞，整个 CompletableFuture<Integer> 处于未完成状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("计算结果为：" + i);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> completableFuture=new CompletableFuture<>();
        new Thread(new TestCompletableFuture(completableFuture)).start();
        System.out.println("线程开始");
        Thread.sleep(2000);
        System.out.println("计算结束");
        completableFuture.complete(200); // 将数据载入 CompletableFuture ，并标记为完成状态 ，以让线程继续执行
    }
}


