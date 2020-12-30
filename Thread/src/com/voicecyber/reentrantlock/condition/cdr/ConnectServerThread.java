package com.voicecyber.reentrantlock.condition.cdr;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Sean on 2018/11/7
 *
 * @author Sean
 */
public class ConnectServerThread implements Runnable {
    public volatile static Socket client;
    private String host;
    private Integer port;
    private ConnectUtil connectUtil;

    public ConnectServerThread(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public ConnectServerThread(String host, Integer port, ConnectUtil connectUtil) {
        this.host = host;
        this.port = port;
        this.connectUtil = connectUtil;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("ConnectServerThread");
            if (client == null || client.isClosed()) {
                connect();
            } else {
                connectUtil.awaitConnection();
            }
        }
    }

    private void connect() {
        InetSocketAddress addr = new InetSocketAddress(host, port);
        client = new Socket();
        try {
            client.connect(addr);
            connectUtil.notifyCdr();
        } catch (IOException e) {
            client = null;

        }
    }
}
