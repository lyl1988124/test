package com.lyl.learn.serve.kafka;

/**
 * Created by lyl on 2017/11/23.
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();
    }

}
