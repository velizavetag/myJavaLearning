package com.packageChallenge;

import static com.packageChallenge.Main.lock1;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();


    public static void main(String[] args) {
        // write your code here
        new Thread1().start();
        new Thread2().start();
    }


    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread one: has lock1 ");
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {

                }

                System.out.println("Thread one waiting for lock 2");

                synchronized (lock2) {
                    System.out.println("Thread 1: has lock1 and lock2");
                }
                System.out.println("Thread 1: releases lock2");
            }
            System.out.println("Thread 1: released lock 1, Exiting...");
        }
    }


    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2 : has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting lock 2");

                synchronized (lock2) {
                    System.out.println("Thread 2: has lock1 and lock2");

                }

                System.out.println("Thread 2: released lock2");

            }
            System.out.println("Thread 2: released lock1. Exiting...");

        }
    }
}