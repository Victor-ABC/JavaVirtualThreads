package fh.fep.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleTasks {

    public static void main(String[] args) {
        //Start Time
        long startTime = System.currentTimeMillis();
        ExecutionStrategy strategy = ExecutionStrategy.JavaVirtualThreads;
        compute(strategy, 24, 10);
        //End Time
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Duration: " + estimatedTime + " Milliseconds");
    }

    private static void compute(ExecutionStrategy strategy, int numberOfThreads, int numberOfTasks) {
        //Assign Tasks to ThreadPool
        Map<Integer, Future<String>> futureMapOfRandomNumbers = null;
        switch (strategy) {
            case JavaPlatformThreads -> futureMapOfRandomNumbers = runFixedThreadPool(numberOfThreads,
                    numberOfTasks);
            case JavaVirtualThreads -> futureMapOfRandomNumbers = runVirtualThreadPool(numberOfTasks);
            default -> System.out.println("unsopported");
        }
        //Wait for every result to return (blocking)
        for (Entry<Integer, Future<String>> entry : futureMapOfRandomNumbers.entrySet()) {
            try {
                Integer key_taskId = entry.getKey();
                String value_weather = entry.getValue().get();
                //System.out.println(key_taskId + ":" + value_weather);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<Integer, Future<String>> runFixedThreadPool(int numberOfThreads, int numberOfTasks) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(numberOfThreads);
        return getIntegerFutureMap(numberOfTasks, fixedThreadPool);
    }

    public static Map<Integer, Future<String>> runVirtualThreadPool(int numberOfTasks) {
        ExecutorService fixedThreadPool = Executors.newVirtualThreadPerTaskExecutor();
        return getIntegerFutureMap(numberOfTasks, fixedThreadPool);
    }

    private static Map<Integer, Future<String>> getIntegerFutureMap(int numberOfTasks,
            ExecutorService executorService) {
        Map<Integer, Future<String>> futureList = new HashMap<>();
        for (int i = 0; i < numberOfTasks; i++) {
            Future<String> future = executorService.submit(new Task(i, "London"));
            futureList.put(i + 1, future);
        }
        return futureList;
    }

}