package com.lyl.thrift;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by lyl on 2018/6/22.
 */
public class HelloServiceServer {
    public static void main(String[] args) {
        /*
        //单个service start
        System.out.println("single service服务端开启....");
        TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        // 简单的单线程服务模型
        TServerTransport serverTransport = null;
        try {
            serverTransport = new TServerSocket(9898,10000);
        } catch (TTransportException e) {
            e.printStackTrace();
        }



        //TServer.Args tArgs = new TServer.Args(serverTransport);
        TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        //TServer server = new TSimpleServer(tArgs);
        TServer server = new TThreadPoolServer(tArgs);
        server.serve();
        */
        //当个service end


        //多个service start
        System.out.println("Multiple service服务端开启....");
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        processor.registerProcessor("helloService",new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl()));
        // 简单的单线程服务模型
        TServerTransport serverTransport = null;
        try {
            serverTransport = new TServerSocket(9898,10000);
        } catch (TTransportException e) {
            e.printStackTrace();
        }



        //TServer.Args tArgs = new TServer.Args(serverTransport);
        TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
        tArgs.processor(processor);
        System.out.println("来啦");
        tArgs.protocolFactory(new TCompactProtocol.Factory());
        //TServer server = new TSimpleServer(tArgs);
        TServer server = new TThreadPoolServer(tArgs);
        server.serve();
        //多个service end
    }
}

