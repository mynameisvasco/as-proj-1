package as.proj1.hospital.common;

import as.proj1.hospital.interfaces.IConsumer;
import as.proj1.hospital.interfaces.IProducer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MFifo implements IConsumer, IProducer {

    private int idxGet = 0;
    private int idxPut = 0;
    private int count = 0;

    private final int[] fifo;
    private final int size;
    private final ReentrantLock rl;
    private final Condition cNotFull;
    private final Condition cNotEmpty;

    public MFifo(int size) {
        this.size = size;
        fifo = new int[size];
        rl = new ReentrantLock();
        cNotEmpty = rl.newCondition();
        cNotFull = rl.newCondition();
    }

    @Override
    public void put(int value) {
        try {
            rl.lock();

            while (isFull()) {
                cNotFull.await();
            }

            fifo[idxPut] = value;
            idxPut = (idxPut + 1) % size;
            count++;
            cNotEmpty.signal();
        } catch (InterruptedException ignored) {
        } finally {
            rl.unlock();
        }
    }

    @Override
    public int get() {
        try {
            rl.lock();

            try {
                while (isEmpty()) {
                    cNotEmpty.await();
                }

                var result = fifo[idxGet];
                idxGet = (idxGet + 1) % size;
                count--;
                cNotFull.signal();
                return result;
            } catch (InterruptedException ignored) {
            }

        } finally {
            rl.unlock();
        }

        return 0;
    }

    private boolean isFull() {
        return count == size;
    }

    private boolean isEmpty() {
        return count == 0;
    }
}
