package com.voicecyber.synchronizied;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class CountNum {
    private int num=0;
    public int getNum() {
        return num;
    }
    public void count() throws InterruptedException {
        synchronized (this){
            num++;
        }
    }
}
