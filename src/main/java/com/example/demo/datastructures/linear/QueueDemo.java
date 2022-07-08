package com.example.demo.datastructures.linear;

import java.util.Arrays;

public class QueueDemo {

  public static void main(String[] args) {

    QueueUsingArray<Integer> queueUsingArray = new QueueUsingArray<>(4);
    queueUsingArray.enQueue(1);
    queueUsingArray.enQueue(2);
    queueUsingArray.enQueue(3);
    queueUsingArray.enQueue(4);
    queueUsingArray.enQueue(5);

    queueUsingArray.display();

    queueUsingArray.deQueue();
    queueUsingArray.deQueue();
    queueUsingArray.deQueue();
    queueUsingArray.deQueue();
    queueUsingArray.deQueue();
    queueUsingArray.display();

  }

}

class QueueUsingArray<T> {

  private int rearIndex;
  private int frontIndex;
  private int size;
  private Object[] array;

  QueueUsingArray(int size) {
    this.size = size;
    array = new Object[size];
  }

  void enQueue(T t) {
    if (rearIndex < size) {
      array[rearIndex] = t;
      rearIndex++;
    } else {
      System.out.println("Queue is full");
    }
  }

  void deQueue() {

    if (rearIndex == frontIndex) {
      System.out.println("Queue is empty");
    } else {
      Object[] updatedArray = new Object[size - 1];
      for (int i = 0; i < size - 1; i++) {
        updatedArray[i] = array[i + 1];
      }
      array = updatedArray;
      size--;
      rearIndex--;
    }
  }

  void display() {
    System.out.println(Arrays.toString(array));
  }


}
