package com.voicecyber.synchronizied;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class CountNum2 {
    private int num = 0;

    public int getNum() {
        return num;
    }

    synchronized public void count() throws InterruptedException {
        num++;
    }
}
