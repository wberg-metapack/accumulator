package nu.mine.wberg.metapack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AccumulatorImplTest {

    private AccumulatorImpl accumulatorImpl;

    @Before
    public void before() {
        accumulatorImpl = new AccumulatorImpl();
    }

    @Test
    public void isInitialisedWithZero() {
        assertEquals(0, accumulatorImpl.getTotal());
    }

    @Test
    public void accumulateOne_accumulates() {
        accumulatorImpl.accumulate(1);
        assertEquals(1, accumulatorImpl.getTotal());
    }

    @Test
    public void accumulateMultiple_returnsSum() {
        assertEquals(2, accumulatorImpl.accumulate(1,1));
    }

    @Test
    public void accumulateMultiple_accumulates() {
        accumulatorImpl.accumulate(1,1);
        assertEquals(2, accumulatorImpl.getTotal());
    }

    @Test
    public void accumulateSequence_accumulates() {
        accumulatorImpl.accumulate(1);
        accumulatorImpl.accumulate(1);
        assertEquals(2, accumulatorImpl.getTotal());
    }

    @Test
    public void reset_resetsToZero() {
        accumulatorImpl.accumulate(1);
        accumulatorImpl.reset();
        assertEquals(0, accumulatorImpl.getTotal());
    }
}
