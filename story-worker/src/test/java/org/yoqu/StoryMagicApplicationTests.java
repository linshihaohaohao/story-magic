package org.yoqu;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class StoryMagicApplicationTests implements Runnable {

    private ConcurrentLinkedQueue concurrentLinkedQueue;

    public StoryMagicApplicationTests(ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        StoryMagicApplicationTests threadTest = new StoryMagicApplicationTests(concurrentLinkedQueue);
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            Thread thread1 = new Thread(threadTest);
            threads[i] = thread1;
        }
        long startTimes = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTimes = System.currentTimeMillis();
        System.out.println("完成ConcurrentLinkedQueue所有任务，花费的时间为：" + ((endTimes - startTimes) / 1000f) + ", 队列数据：" + concurrentLinkedQueue.size());
        threadTest.testBlockQueue();
    }

    public void testBlockQueue() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Thread[] ths= new Thread[10000];
        Threadtwo threadtwo = new Threadtwo(linkedBlockingDeque);
        for (int i = 0; i < 10000; i++) {
            Thread th = new Thread(threadtwo);
            ths[i]=th;
        }
        long startTimes = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            ths[i].start();
            try {
                ths[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTimes = System.currentTimeMillis();
        System.out.println("完成LinkedBlockingQueue所有任务，花费的时间为：" + ((endTimes - startTimes) / 1000f) + ", 队列数据：" + concurrentLinkedQueue.size());
    }

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            concurrentLinkedQueue.add(j);
//            System.out.println("thread: "+ Thread.currentThread().getId()+" add value:"+j);
        }
    }

    private class Threadtwo implements Runnable {

        private LinkedBlockingDeque linkedBlockingDeque;

        public Threadtwo(LinkedBlockingDeque linkedBlockingDeque) {
            this.linkedBlockingDeque = linkedBlockingDeque;
        }

        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                linkedBlockingDeque.add(j);
            }
        }
    }
}