package com.nehru.datastructures.linear;

public class SinglyLinkedListDemo {

  public static void main(String[] args) {
    SinglyLL singlyLL = new SinglyLL();

    singlyLL.delete(5);
    singlyLL.add(1);
    singlyLL.add(2);
    singlyLL.add(3);
    singlyLL.add(4);
    singlyLL.add(5);

    singlyLL.delete(8);
    singlyLL.delete(1);

    singlyLL.display();
  }

}


class SinglyLL {

  Node head;

  class Node {

    Node next;
    int value;

    Node(int value) {
      this.value = value;
    }
  }

  void add(int value) {
    if (head == null) {
      head = new Node(value);
    } else {
      Node last = head;
      while (last.next != null) {
        last = last.next;
      }
      last.next = new Node(value);
    }
  }

  void delete(int value) {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node previous = null;
    Node current = head;

    // In case value is found at first it will not have previous value
    if (head.value == value) {
      head = head.next;
      return;
    }

    //
    while (current != null && current.value != value) {
      previous = current;
      current = current.next;

    }

    if (current == null) {
      System.out.println("Not found");
      return;
    }

    previous.next = current.next;

  }

  void display() {
    Node node = head;
    if (node == null) {
      System.out.println("List is empty");
    }

    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }

  }

}
