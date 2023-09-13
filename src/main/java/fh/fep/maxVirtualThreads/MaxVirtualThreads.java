package fh.fep.maxVirtualThreads;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class MaxVirtualThreads {

    // --enable-preview

    public static void main(String[] args) throws InterruptedException {

        // virtual thread
        var threads =
                IntStream.range(0, 1_000)
                        .mapToObj(index ->
                                Thread.ofVirtual()
                                        .name("platform-", index)
                                        .unstarted(() -> {
                                            try {
                                                Thread.sleep(2_000);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                        }))
                        .toList();

        Instant begin = Instant.now();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        Instant end = Instant.now();
        System.out.println("Duration = " + Duration.between(begin, end));
    }
}