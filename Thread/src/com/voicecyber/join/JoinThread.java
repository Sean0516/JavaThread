package com.voicecyber.join;

/**
 * Created by Sean on 2018/7/5
 *
 * @author Sean
 */
public class JoinThread implements Runnable{
    public   int num;
    public JoinThread(int num){
        this.num=num;
    }
    @Override
    public void run() {
        add();
    }

    public synchronized void add(){
        for (int i = 0; i <10 ; i++) {
            num++;
            System.out.println("线程"+Thread.currentThread().getName()+ "number:"+num);
        }
    }

    public int getNum() {
        return num;
    }
}
