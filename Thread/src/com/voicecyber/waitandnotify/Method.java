package com.voicecyber.waitandnotify;

/**
 * Created by Sean on 2018/7/4
 *
 * @author Sean
 */
public class Method {
    private long money = 0L;
    private final static long MAX_MONEY = 500L;

    public synchronized void produce() {
        money += 200L;
        System.out.printf("生产money%d ---当前money%d----当前线程 %s", 200L, money, Thread.currentThread().getName());
        System.out.println("____");
        notifyAll();
    }

    public synchronized void customer() {
        while (money - 300 <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money -= 300L;
        System.out.printf("消费money%d ---剩余money%d----当前线程 %s", 300, money, Thread.currentThread().getName());
        System.out.println("____");
        notifyAll();

    }

}
