package com.lyl.flink;

import com.lyl.flink.kafkaUtil.KafkaEvent;
import com.lyl.flink.kafkaUtil.KafkaExampleUtil;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;
import org.apache.flink.streaming.util.serialization.KeyedSerializationSchemaWrapper;

/**
 * Created by lyl on 2018/11/12.
 */
public class KafkaExample extends KafkaExampleUtil {


}
