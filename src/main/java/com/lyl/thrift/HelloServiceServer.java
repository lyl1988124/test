package com.lyl.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by lyl on 2018/6/22.
 */
public class HelloServiceServer {
    public static void main(String[] args) {
        System.out.println("服务端开启....");
        TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        // 简单的单线程服务模型
        TServerTransport serverTransport = null;
        try {
            serverTransport = new TServerSocket(9898);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(tArgs);
        server.serve();
    }
}

