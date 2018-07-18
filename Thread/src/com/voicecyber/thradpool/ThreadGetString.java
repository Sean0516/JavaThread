package com.voicecyber.thradpool;

import java.util.concurrent.Callable;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class ThreadGetString implements Callable {
    @Override
    public Object call() throws Exception {

        return Thread.currentThread().getName()+" say hello";

    }
}
