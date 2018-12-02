package flink;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by lyl on 2018/11/15.
 */
public class SumReduceTest {

    @Test
    public void testSum() throws Exception {
        // instantiate your function
        SumReduce sumReduce = new SumReduce();

        // call the methods that you have implemented
        Assert.assertEquals(42L,sumReduce.reduce(1L,41L).longValue());
    }
}
