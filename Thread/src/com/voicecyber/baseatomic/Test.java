package com.voicecyber.baseatomic;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        CountByAtomic countByAtomic=new CountByAtomic();
        for (int i = 0; i <2 ; i++) {
            new Thread(countByAtomic).start();
        }

    }

}
