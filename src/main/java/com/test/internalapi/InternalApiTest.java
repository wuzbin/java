package com.test.internalapi;

import com.sohu.reader.internal.api.ApiException;
import com.sohu.reader.internal.api.client.InternalApiClient;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-4-28
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class InternalApiTest {

    private static List<Long> times = new ArrayList<Long>();

    private static SortedMap<Long, Integer> statis = new TreeMap<Long, Integer>();
    public static void main(String[] args){
        if (args.length < 1) {
            System.err.println("请指定存放source id的文件");
            System.out.println("java -cp java-1.0-SNAPSHOT.jar  com.test.internalapi.InternalApiTest filePath");
            System.exit(1);
        }

        String fileName = args[0];
        int c = 10;
        if (args.length == 2) {
            c = Integer.parseInt(args[1]);
        }
        String host = "10.13.83.119:8090";
        if (args.length == 3) {
            host = args[2];
        }
        ExecutorService service = Executors.newFixedThreadPool(10);
        final InternalApiClient client = InternalApiClient.create(host);
        List<Long> sourceIds = getSourceIds(fileName);
        List<Future> futures = new ArrayList<Future>();
        AtomicInteger finished = new AtomicInteger(0);
        System.out.println("total source size is " + sourceIds.size());
        for (final long sourceId : sourceIds) {
            Future f = service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        long start = System.currentTimeMillis();
                        client.getFetches(sourceId);
                        long end = System.currentTimeMillis();
                        long time = end - start;
                        logTime(time);
                    } catch (ApiException e) {
                        System.err.println("api error");
                    }
                }
            });
            futures.add(f);
        }
        service.shutdown();
        while (!service.isTerminated()) {
            Iterator<Future> it = futures.iterator();
            while (it.hasNext()){
                Future f = it.next();
                if(f.isDone()) {
                    it.remove();
                    finished.addAndGet(1);
                    if (finished.get() % 100 == 0) {
                        System.out.println("finished count is " + finished.get());
                    }
                }
            }
        }
        if (service.isTerminated()) {
            System.out.println("finished count is " + finished.get());
            printStatis();
        }
    }
    private static void logTime(long time) {
        synchronized (times) {
            times.add(time);
        }
    }
    private static void printStatis() {
        Collections.sort(times);
        int timeSize = times.size();
        int nf = (int)(timeSize * 0.95);
        int nt = (int)(timeSize * 0.90);
        long totalTime = 0;
        for(Long time : times) {
            long key = (time / 10) * 10;
            if (key > 1000) {
                key = 1000;
            }
            Integer count = statis.get(key);
            if (count == null) {
                count = 0;
            }
            statis.put(key, count + 1);
            totalTime += time;
        }
        System.out.println("Mean: " + totalTime/timeSize);
        System.out.println("90th<: " + times.get(nt));
        System.out.println("95th<: " + times.get(nf));
        for (Long key : statis.keySet()) {
            System.out.println(key + "  " + statis.get(key));
        }
    }
    private static List<Long> getSourceIds(String fileName) {
        List<Long> sourceIds = new ArrayList<Long>();
        File file = new File(fileName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                sourceIds.add(Long.parseLong(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sourceIds;
    }
}
