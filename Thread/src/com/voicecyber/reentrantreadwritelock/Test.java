package com.voicecyber.reentrantreadwritelock;

/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        ReadWriteService readWriteService=new ReadWriteService();
        ThreadGroup threadGroup=new ThreadGroup("线程组");
       ReadThread readThread=new ReadThread(readWriteService);
        WriteThread writeThread=new WriteThread(readWriteService);
        ReadThread readThread1=new ReadThread(readWriteService);
        WriteThread writeThread1=new WriteThread(readWriteService);
        readThread.setName("read 线程 1");
        writeThread.setName("write 线程 1");
        readThread1.setName("read 线程 2 ");
        writeThread1.setName("write 线程 2");

        writeThread.start();
        readThread1.start();
        readThread.start();
        writeThread1.start();





    }
}
