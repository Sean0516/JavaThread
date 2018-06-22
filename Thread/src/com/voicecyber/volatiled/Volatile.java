package com.voicecyber.volatiled;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class Volatile extends Thread {
    volatile  private int num=0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("num="+num +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (num==110){
                break;
            }
        }
    }
}
