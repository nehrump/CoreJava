package com.example.demo.problems;

public class LLDemo {

  public static void main(String[] args) {
    LL ll = new LL();
    ll.insert(1);
    ll.insert(2);
    ll.insert(3);
    ll.insert(4);

    ll.reverse();
    ll.delete(3);
    ll.display();
  }

}

class LL {

  private Node head;

  static class Node {

    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  void insert(int value) {
    if (head == null) {
      head = new Node(value);
    } else {
      Node newNode = new Node(value);
      Node currentNode = head;

      while (currentNode.next != null) {
        currentNode = currentNode.next;

      }
      currentNode.next = newNode;

    }
  }

  void delete(int value) {
    Node currentNode = head;
    Node previousNode = null;

    if (currentNode != null && currentNode.value == value) {
      currentNode = currentNode.next;
    }

    while (currentNode != null && currentNode.value != value) {
      previousNode = currentNode;
      currentNode = currentNode.next;
    }
    if (currentNode != null && previousNode != null) {
      previousNode.next = currentNode.next;
    } else {
      System.out.println("Key not found");
    }


  }

  void reverse() {
    Node currentNode = head;
    Node nextNode = null;
    Node previousNode = null;

    while (currentNode != null) {
      nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }
    head = previousNode;

  }

  void display() {
    Node currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.value + " ");
      currentNode = currentNode.next;
    }
  }

}
