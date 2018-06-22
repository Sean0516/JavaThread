package com.voicecyber.volatiled;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class Test2 {
    public static void main(String[] args) {
        AtomicClass atomicClass=new AtomicClass();
        for (int i = 0; i <5 ; i++) {
            new Thread(atomicClass).start();
        }
    }
}
