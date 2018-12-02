package flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPunctuatedWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.util.Collector;

import javax.annotation.Nullable;
import java.util.Properties;

/**
 * Created by lyl on 2018/11/16.
 */
public class FlinkKafkaData {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        // only required for Kafka 0.8
        //properties.setProperty("zookeeper.connect", "localhost:2181");
        //properties.setProperty("group.id", "test");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.enableCheckpointing(1000); // 非常关键，一定要设置启动检查点！！
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        FlinkKafkaConsumer011 kafkaConsumer011 = new FlinkKafkaConsumer011<>(
                java.util.regex.Pattern.compile("flink-[0-9]"),
                //"flink-0",
                new SimpleStringSchema(),properties);

        kafkaConsumer011.assignTimestampsAndWatermarks(new AssignerWithPunctuatedWatermarks<String>() {
            @Nullable
            @Override
            public Watermark checkAndGetNextWatermark(String lastElement, long l) {
                if (lastElement != null && lastElement.contains(",")) {
                    String[] parts = lastElement.split(",");
                    return new Watermark(Long.parseLong(parts[0]));
                }
                return null;
            }

            @Override
            public long extractTimestamp(String element, long l) {
                if (element != null && element.contains(",")) {
                    String[] parts = element.split(",");
                    return Long.parseLong(parts[0]);
                }
                return 0L;
            }
        });


        kafkaConsumer011.setStartFromLatest();

//        DataStream<Tuple2<String, Long>> stream = env
//                .addSource(kafkaConsumer011);
        DataStream<String> stream = env.addSource(kafkaConsumer011);
        DataStream counts = stream.flatMap(new Splitter()).keyBy(0).sum(1);

        counts.print();

        env.execute();


    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word: sentence.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }

    public static final class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        private static final long serialVersionUID = 1L;

        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
            String[] tokens = value.toLowerCase().split("\\W+");
            for (String token : tokens) {
                if (token.length() > 0) {
                    out.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }

}

class MessageSplitter implements FlatMapFunction<String,Tuple2<String,Long>>{

    @Override
    public void flatMap(String s, Collector<Tuple2<String, Long>> collector) throws Exception {

    }
}

