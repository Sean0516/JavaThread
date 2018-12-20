package com.voicecyber.executors.invokeAny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class TestVinvokeAll {
    public static void main(String[] args) {
        List<Callable<String>> list = new ArrayList(2);
        list.add(new ThreadA());
        list.add(new ThreadA());
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            List<Future<String>> futures = executorService.invokeAll(list);
            for (Future<String> future : futures) {
                System.out.println("返回结果为："+future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
