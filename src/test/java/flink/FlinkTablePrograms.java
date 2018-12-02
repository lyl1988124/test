package flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.table.sinks.CsvTableSink;
import org.apache.flink.table.sinks.TableSink;
import org.apache.flink.types.Row;

/**
 * Created by lyl on 2018/11/15.
 */
public class FlinkTablePrograms {
    public static void main(String[] args) throws Exception {
        // for batch programs use ExecutionEnvironment instead of StreamExecutionEnvironment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // create a TableEnvironment
        StreamTableEnvironment tableEnv = TableEnvironment.getTableEnvironment(env);

        DataStream<Tuple2<String, Integer>> dataStream = env
                .socketTextStream("localhost", 9999)
                .map(new Splitter())
                .keyBy(0)
                .timeWindow(Time.seconds(5))
                .sum(1);

        tableEnv.registerDataStream("Table1", dataStream,"f0,f1");


        //Table result1 = tableEnv.fromDataStream(dataStream,"f0,f1");

        //dataStream.print();

        Table result2 = tableEnv.sqlQuery("SELECT f0,f1  " +
                "FROM Table1");


        // create a TableSink
        TableSink sink = new CsvTableSink("/Users/lyl/folder/workspace/ideaspace/test/myfile", "|");

        String[] fieldNames = {"a", "b"};
        TypeInformation[] fieldTypes = {Types.STRING, Types.INT};
        tableEnv.registerTableSink("CsvSinkTable", fieldNames, fieldTypes, sink);
        //   Emit the result Table to the registered TableSink via the insertInto() method
        result2.insertInto("CsvSinkTable");


        //将查询结果转换为Stream，并打印输出
        tableEnv.toAppendStream(result2, Row.class).print();

        env.execute();

    }

    public static class Splitter implements MapFunction<String, Tuple2<String, Integer>> {

        @Override
        public Tuple2<String, Integer> map(String s) throws Exception {
            int a =0;
            for(String tmps : s.split(" ")){
                a++;
            }
            return  new Tuple2<String, Integer>(s, a);
        }
    }
}


