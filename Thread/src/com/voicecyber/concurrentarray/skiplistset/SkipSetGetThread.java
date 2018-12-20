package com.voicecyber.concurrentarray.skiplistset;

import com.voicecyber.concurrentarray.skiplistmap.SkipMapGetThread;
import com.voicecyber.concurrentarray.skiplistmap.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Sean on 2018/12/19
 *
 * @author Sean
 */
public class SkipSetGetThread implements Runnable{
    private ConcurrentSkipListSet<User> concurrentSkipListSet;

    public SkipSetGetThread(ConcurrentSkipListSet<User> concurrentSkipListSet) {
        this.concurrentSkipListSet = concurrentSkipListSet;
    }

    @Override
    public void run() {
        while (!concurrentSkipListSet.isEmpty()){
            User first = concurrentSkipListSet.pollFirst();
            System.out.println(Thread.currentThread().getName() +"----" +first.toString());
        }
    }

    public static void main(String[] args) {
        ConcurrentSkipListSet<User> concurrentSkipListSet =new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add(new User("sean",12));
        concurrentSkipListSet.add(new User("zhao",22));
        concurrentSkipListSet.add(new User("sean",12));
        concurrentSkipListSet.add(new User("master",10));
        concurrentSkipListSet.add(new User("Lee",30));
        concurrentSkipListSet.add(new User("EK",20));
        Thread thread=new Thread(new SkipSetGetThread(concurrentSkipListSet));
        thread.setName("ThreadA");
        thread.start();

    }
}
