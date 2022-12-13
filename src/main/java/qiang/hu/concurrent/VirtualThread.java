package qiang.hu.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class VirtualThread {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            log.info("Starting 10000 tasks" + LocalTime.now());
            IntStream.range(0, 10000).forEach(i -> executor.submit(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        } finally {
            log.info("Executor closed" + LocalTime.now());
        }
    }
}
