package com.voicecyber.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Sean on 2018/7/12
 *
 * @author Sean
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD=20;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end -start) <=THRESHOLD;
        if (canCompute){
            for (int i =start;i<=end;i++){
                sum+=i;
            }
            System.out.println("sum:"+sum);
        }else {
            int middle =(start +end)/2;
            CountTask leftTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;
        }
    return  sum;
    }
}
