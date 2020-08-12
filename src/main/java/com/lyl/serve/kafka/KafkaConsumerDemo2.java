package com.lyl.serve.kafka;

/**
 * Created by lyl on 2017/11/23.
 */
public class KafkaConsumerDemo2 {
    public static void main(String[] args) {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}
