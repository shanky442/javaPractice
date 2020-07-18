package com.learningsJava;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {

        PC pcInstance = new PC();
        Thread t1 = new Thread(()->{
            try {
                pcInstance.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                pcInstance.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
    }

    public static class PC {
        List<Integer> list = new LinkedList<>();
        int initialCapacity = 1;
        public void produce() throws InterruptedException {
            int value=10;
            while(true) {
                synchronized(list) {
                    if(list.size()<initialCapacity) {
                        value++;
                        list.add(value);
                        Thread.sleep(1000);
                        System.out.println("producer produced "+value);
                    } else {
                        list.notify();
                        //this.wait();
                    }
                }

            }
        }

        public void consume() throws InterruptedException {
            System.out.println("inside consumer");
            //this.wait(); // so that consumer starts only when it is notified by producer
            /*for(int i:list) {
                System.out.println("elements in list are "+i);
            }*/
            while(true) {
                synchronized (list) {
                    if (!list.isEmpty()) {
                        System.out.println("consumer consumed " + list.remove(0));
                        Thread.sleep(1000); //so that we can see the output
                    } else {
                        //this.notify();
                        list.wait();
                    }
                }
            }
        }
    }

}

