package com.lyl.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by lyl on 2018/6/22.
 */
public class HelloServiceClient {
    public static void main(String[] args) {
        System.out.println("客户端启动....");
        TTransport transport = null;
            transport = new TSocket("localhost", 9898, 30000);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            MyParam myParam = new MyParam();
            myParam.setPara("bbb");
            result = client.helloString(myParam);
        } catch (TException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
