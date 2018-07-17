package com.voicecyber.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class ShowMessageTask extends RecursiveAction{
    private static final int THRESHOLD=2;
    private int start;
    private int end;

    public ShowMessageTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        boolean canCompute=(end-start)<=THRESHOLD;
        if (canCompute){
            System.out.println("执行一次任务");
            throw new RuntimeException("空指针异常测试");
        }else {
            int middle=(start+end)/2;
            ShowMessageTask leftTask=new ShowMessageTask(start,middle);
            ShowMessageTask rightTask=new ShowMessageTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
        }
    }
}
