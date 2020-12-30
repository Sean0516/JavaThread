package com.voicecyber.reentrantlock.condition.cdr;

/**
 * @Description Test
 * @Author Sean
 * @Date 2020/12/21 16:01
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ConnectUtil connectUtil=new ConnectUtil();
        ConnectServerThread connectServerThread=new ConnectServerThread("192.168.12.199",25000,connectUtil);
        TcpMonitorThread tcpMonitorThread =new TcpMonitorThread("192.168.12.199",25000,connectUtil);
        new Thread(connectServerThread).start();
        new Thread(tcpMonitorThread).start();
    }
}
