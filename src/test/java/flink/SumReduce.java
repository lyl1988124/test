package flink;

import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by lyl on 2018/11/15.
 */
public class SumReduce implements ReduceFunction<Long> {

    @Override
    public Long reduce(Long value1, Long value2) throws Exception {
        return value1 + value2;
    }
}
