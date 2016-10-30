package nu.mine.wberg.metapack.accumulator;

import static org.junit.Assert.assertEquals;

import nu.mine.wberg.metapack.accumulator.AccumulatorImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The test name format (action_expectedResult) is completely non-standard
 * but I have yet to discover a more readable way of describing test activity.
 * On the whole I tend to copy local naming conventions, so I rarely use this
 * format in practice.
 *
 * There are no tests here which test thread safety, because thread safety is
 * hard to test deterministically (i.e. non-threadsafe code sometimes appears
 * threadsafe). The best way to manage potentially unsafe concurrent code is
 * to minimise its concurrent aspect into an untested delegator which assigns
 * single-threaded code.
 */
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
    public void accumulateOne_returnsOne() {
        assertEquals(1, accumulatorImpl.accumulate(1));
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
