package com.voicecyber.calllable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Sean on 2018/6/20
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        ThreadByCallAble threadByCallAble = new ThreadByCallAble();
        FutureTask futureTask = new FutureTask(threadByCallAble);
        new Thread(futureTask).start();
        try {
            System.out.println("获取任务结果");
            Object o = futureTask.get();
            System.out.println("输出任务结果");
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
