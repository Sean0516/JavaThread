package com.voicecyber.reentrantlock.condition.cdr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Sean on 2018/11/7
 *
 * @author Sean
 */
public class TcpMonitorThread implements Runnable {
    private BufferedReader bufferedReader;
    private String ip;
    private Integer port;
    private ConnectUtil connectUtil;

    public TcpMonitorThread(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public TcpMonitorThread(String ip, Integer port, ConnectUtil connectUtil) {
        this.ip = ip;
        this.port = port;
        this.connectUtil = connectUtil;
    }

    @Override
    public void run() {
        while (true) {
            Socket client = ConnectServerThread.client;
            if (client == null || client.isClosed()) {
                connectUtil.notifyConnection();
                connectUtil.awaitCdr();
            } else {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String response;
                    while ((response = bufferedReader.readLine()) != null) {
                        System.out.println("response "+ response);
                    }
                } catch (IOException e) {
//                LOGGER.error("read msg from smdr server as " + e.getMessage());
                } finally {
                    try {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (client != null) {
                            client.close();
                        }
                    } catch (IOException e) {
//                    LOGGER.error("close client and io bufferedReader error as " + e.getMessage());
                    }
                }
            }
        }

    }

}
