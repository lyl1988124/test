package flink;

import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;

/**
 * Created by lyl on 2018/11/16.
 */
public class BoundedOutOfOrdernessGenerator implements AssignerWithPeriodicWatermarks {

    private final long maxOutOfOrderness = 3500; // 3.5 seconds

    private long currentMaxTimestamp;

    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return null;
    }

    @Override
    public long extractTimestamp(Object o, long l) {
        return 0;
    }
}
