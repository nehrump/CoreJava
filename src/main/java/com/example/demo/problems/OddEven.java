package com.example.demo.problems;

public class OddEven {

    int counter = 1;
    int target = 10;

    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        new Thread(oddEven::printOdd).start();
        new Thread(oddEven::printEven).start();


    }

    private void printOdd() {
        synchronized (this) {
            while (counter < target) {

                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Thread" + Thread.currentThread().getName() + " : " + counter);
                counter++;
                notify();

            }
        }


    }

    private void printEven() {
        synchronized (this) {
            while (counter < target) {

                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Thread" + Thread.currentThread().getName() + " : " + counter);
                counter++;
                notify();

            }
        }


    }
}
