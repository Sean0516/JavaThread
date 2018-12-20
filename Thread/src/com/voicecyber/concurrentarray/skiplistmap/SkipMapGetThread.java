package com.voicecyber.concurrentarray.skiplistmap;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class SkipMapGetThread implements Runnable {
    private ConcurrentSkipListMap<User,String> concurrentSkipListMap;

    public SkipMapGetThread(ConcurrentSkipListMap<User, String> concurrentSkipListMap) {
        this.concurrentSkipListMap = concurrentSkipListMap;
    }

    @Override
    public void run() {
        while (!concurrentSkipListMap.isEmpty()){
            Map.Entry<User, String> userStringEntry = concurrentSkipListMap.pollFirstEntry();
            User key = userStringEntry.getKey();
            System.out.println(Thread.currentThread().getName()+"user: " +key.toString()+"value： " +userStringEntry.getValue());
        }
    }

    public static void main(String[] args) {
        ConcurrentSkipListMap<User,String> concurrentSkipListMap=new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put(new User("sean",12),"hello sean ");
        concurrentSkipListMap.put(new User("zhao",22),"hello zhao");
        concurrentSkipListMap.put(new User("master",10),"hello master");
        concurrentSkipListMap.put(new User("Lee",30),"hello Lee");
        concurrentSkipListMap.put(new User("EK",20),"hello EK");
        Thread thread=new Thread(new SkipMapGetThread(concurrentSkipListMap));
        thread.setName("ThreadA");
        Thread thread1=new Thread(new SkipMapGetThread(concurrentSkipListMap));
        thread1.setName("ThreadB");
        thread.start();
        thread1.start();
    }
}
