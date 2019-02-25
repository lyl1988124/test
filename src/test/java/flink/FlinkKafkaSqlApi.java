package flink;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.Kafka011JsonTableSource;
import org.apache.flink.streaming.connectors.kafka.Kafka011TableSource;
import org.apache.flink.streaming.connectors.kafka.KafkaJsonTableSource;
import org.apache.flink.streaming.util.serialization.JSONKeyValueDeserializationSchema;
import org.apache.flink.streaming.util.serialization.KeyedDeserializationSchemaWrapper;
import org.apache.flink.streaming.util.serialization.TypeInformationKeyValueSerializationSchema;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.TableSchema;
import org.apache.flink.table.api.Types;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.types.Row;


import java.io.IOException;
import java.util.*;

/**
 * Created by lyl
 * Date 2018/11/25
 */
public class FlinkKafkaSqlApi {

    private static final String KAFKATOPIC = "test";
    private static final String KAFKASERVER = "localhost:9092";


    public static void main(String[] args) throws Exception {
//
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        StreamTableEnvironment tableEnvironment = TableEnvironment.getTableEnvironment(env);
//
//        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers", KAFKASERVER);
//        properties.setProperty("group.id", "flink_user");
//
//        //String schema = "{\"id\":\"int\",\"name\":\"string\",\"score\":\"int\",\"currentTimeStamp\":\"long\"}";
//        String schema = "{\"name\":\"string\",\"score\":\"int\",\"currentTimeStamp\":\"long\"}";
//        JSONObject jsonObject = JSONObject.parseObject(schema);
//
//        //字典映射
//        Map<String, TypeInformation> dic = new HashMap<>();
//        dic.put("string", Types.STRING());
//        dic.put("int", Types.INT());
//        dic.put("long", Types.LONG());
//
//        Set<String> keySet = jsonObject.keySet();
//
//        String[] key = keySet.toArray(new String[keySet.size()]);
//
//        List<TypeInformation> valueList = new ArrayList<>();
//        for (String i : keySet) {
//            valueList.add(dic.get(jsonObject.getString(i)));
//        }
//
//        TypeInformation<?>[] value = (TypeInformation<?>[]) valueList.toArray(new TypeInformation<?>[valueList.size()]);
//
//        // specify JSON field names and types
//        TypeInformation<Row> typeInfo = Types.ROW(
//                key,
//                value
//        );
//
//        TableSchema tableSchema = new TableSchema(key,value);
//
//        DeserializationSchema deserializationSchema = new DeserializationSchema() {
//            @Override
//            public Object deserialize(byte[] bytes) throws IOException {
//                return MyMessage.fromString(new String(bytes));
//            }
//
//            @Override
//            public boolean isEndOfStream(Object o) {
//                return false;
//            }
//
//            @Override
//            public TypeInformation getProducedType() {
//                return TypeExtractor.getForClass(MyMessage.class);
//            }
//        };
//
//        Kafka011TableSource tableSource = new Kafka011TableSource(tableSchema,KAFKATOPIC,properties,deserializationSchema);
//
//
//
//        tableEnvironment.registerTableSource("table1",tableSource);
//
//
//        Table table = tableEnvironment.sqlQuery("SELECT SUM(score),name FROM table1  group by name");
//
//
//
//        //table to stream for Retract model
//        DataStream<Tuple2<Boolean, Row>> tuple2DataStream = tableEnvironment.toRetractStream(table, Row.class);
//
//        SingleOutputStreamOperator<String> desStream = tuple2DataStream
//                .map(new MapFunction<Tuple2<Boolean, Row>, String>() {
//
//                    @Override
//                    public String map(Tuple2<Boolean, Row> value) throws Exception {
//
//                        return value.f1.toString();
//                    }
//                });
//
//        desStream.print();
//
//        env.execute();

    }
}
