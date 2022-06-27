package com.nehru.datastructures.linear;

public class CircularLinkedListDemo {

  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();
    list.display();
    list.insertElement(1);
    list.insertElement(2);
    list.insertElement(3);
    list.insertElement(4);
    list.display();

  }

}

class CircularLinkedList {

  private Node tail;
  private Node head;
  int size;

  class Node {

    private Node next;
    private final int data;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }


    @Override
    public String toString() {
      return "Node{" +
          "data=" + data +
          ", next=" + next +
          '}';
    }
  }

  void insertElement(int data) {
    Node temp = new Node(data, null);
    if (head == null) {
      head = temp; //
      tail = temp;
      tail.next = temp;
      size++;
    } else {

      tail.next = temp; // replaces tail pointer to new tail pointer
      tail = temp; //
      size++;
    }

  }

  void display() {
    if (head == null) {
      System.out.println("Empty");
    } else {
      Node node = head;
      do {
        System.out.println(node.data);
        node = node.next;
      } while (node != null);
    }

  }


}
