package com.voicecyber.threadexception;

/**
 * Created by Sean on 2018/7/11
 *
 * @author Sean
 */
public class DefaultException extends Thread {
    @Override
    public void run() {
        System.out.println("线程开始， 下面发生异常");
        throw new NullPointerException("空指针异常");
    }
}
