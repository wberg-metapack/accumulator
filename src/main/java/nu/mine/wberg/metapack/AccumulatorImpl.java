package nu.mine.wberg.metapack;

import java.util.concurrent.atomic.AtomicInteger;

public class AccumulatorImpl implements Accumulator {

    private AtomicInteger accumulator;

    public AccumulatorImpl() {
        accumulator = new AtomicInteger();
    }

    public int accumulate(int... values) {
        int acc = 0;
        for(int a : values) {
            acc += a;
        }
        accumulator.addAndGet(acc);
        return acc;
    }

    public int getTotal() {
        return accumulator.get();
    }

    public void reset() {
        accumulator = new AtomicInteger();
    }

}
