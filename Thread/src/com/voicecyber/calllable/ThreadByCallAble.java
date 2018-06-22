package com.voicecyber.calllable;

import java.util.concurrent.Callable;

/**
 * Created by Sean on 2018/6/20
 *
 * @author Sean
 */
public class ThreadByCallAble implements Callable {
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <10 ; i++) {
            sum++;
        }
        return sum;
    }
}
