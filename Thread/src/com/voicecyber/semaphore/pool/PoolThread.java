package com.voicecyber.semaphore.pool;

/**
 * Created by Sean on 2018/12/4
 *
 * @author Sean
 */
public class PoolThread implements Runnable {
    private ListStringPool listStringPool;

    public PoolThread(ListStringPool listStringPool) {
        this.listStringPool = listStringPool;
    }

    @Override
    public void run() {
        while (true){
            String poolValue = listStringPool.getPoolValue();
            System.out.println(Thread.currentThread().getName() +" 取得pool 中的数据： "+ poolValue);
            listStringPool.putValueToPool(poolValue);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ListStringPool listStringPool=new ListStringPool();
        for (int i = 0; i <2 ; i++) {
            Thread thread=new Thread(new PoolThread(listStringPool));
            thread.setName("pool value thread "+i);
            thread.start();
        }

    }
}
