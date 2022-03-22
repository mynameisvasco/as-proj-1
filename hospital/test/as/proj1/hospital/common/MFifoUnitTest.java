package as.proj1.hospital.common;

import java.util.LinkedList;
import java.util.Random;

public class MFifoUnitTest {
    public static void main(String[] args) throws InterruptedException {
        var fifo = new MFifo(5);
        var threads = new LinkedList<Thread>();

        for (int i = 0; i < 10; i++) {
            var producer = new Thread(() -> {
                fifo.put(new Random().nextInt(1,1000));
            });

            var consumer = new Thread(() -> {
                System.out.println(fifo.get());
            });

            threads.add(producer);
            threads.add(consumer);
            consumer.start();
            producer.start();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }
    }
}
