package com.example.demo.datastructures.linear;


public class StackDemo {


  public static void main(String[] args) {
    CustomStack<Integer> stack = new CustomStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.display();

    stack.pop();
    stack.display();
  }


}

class CustomStack<T> {

  private Node<T> node;

  void push(T t) {
    if (node == null) {
      node = new Node<>(t);
    } else {
      Node<T> newNode = new Node<>(t);
      newNode.next = node;
      node = newNode;
    }
  }

  void pop() {
    if (node == null) {
      System.out.println("Stack is empty");
    } else {
      System.out.println(node.data + " is removed");
      node = node.next;

    }

  }

  void display() {
    if (node == null) {
      System.out.println("Stack is empty");
    } else {
      Node<T> currentNode = node;
      while (currentNode != null) {
        System.out.println(currentNode.data + " ");
        currentNode = currentNode.next;
      }

    }

  }

  private static class Node<T> {

    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
    }


  }
}












