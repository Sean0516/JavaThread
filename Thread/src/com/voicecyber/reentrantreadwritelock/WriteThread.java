package com.voicecyber.reentrantreadwritelock;

/**
 * Created by Sean on 2018/7/10
 *
 * @author Sean
 */
public class WriteThread extends Thread {
    private ReadWriteService readWriteService;

    public WriteThread(ReadWriteService readWriteService) {
        this.readWriteService = readWriteService;
    }

    @Override
    public void run() {
        readWriteService.write();
    }
}
