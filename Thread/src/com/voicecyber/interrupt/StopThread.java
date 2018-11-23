package com.voicecyber.interrupt;

/**
 * Created by Sean on 2018/11/14
 *
 * @author Sean
 */
public class StopThread implements Runnable{
    private volatile boolean flag=false;
    @Override
    public void run() {
        while (true){
            if (flag){
                System.out.println("准备退出线程了");
                break;
            }
            System.out.println("hello world ");
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        flag=true;
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread thread=new Thread(stopThread);
        thread.setName("thread one");
        thread.start();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopThread.stop();

    }
}
