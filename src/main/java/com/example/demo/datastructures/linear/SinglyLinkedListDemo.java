package com.example.demo.datastructures.linear;

import java.util.function.Consumer;

public class SinglyLinkedListDemo {

  public static void main(String[] args) {
    LinkList<Integer> singlyLL = new LinkList<>();

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


class LinkList<T> {

  Node<T> head;

  private static class Node<T> {

    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
    }

  }

  void add(T t) {
    if (head == null) {
      head = new Node<>(t);

    } else {
      Node<T> current = new Node<>(t);
      Node<T> temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = current;

    }
  }


  void delete(T t) {
    if (head == null) {
      sout.accept("List is empty");
    } else {
      if (head.data == t) {
        head = head.next;
      } else {
        Node<T> current = head;
        Node<T> previous = null;
        while (current.data != t) {
          previous = current;
          current = current.next;
        }
        sout.accept(current.data + " is removed");
        previous.next = current.next;

      }
    }

  }


  void reverse() {

    if (head == null) {
      sout.accept("List is empty");
    } else {
      Node<T> current = head;
      Node<T> previous = null;
      Node<T> next = null;

      while (current != null) { //1-2-3-null  //2-3-null //3-null
        next = current.next; //2-3-null //3-null //null
        current.next = previous; //null //1-null //2-1-null
        previous = current; //1-null  //2-1-null //3-2-1-null
        current = next; //2-3-null //3-null //null

      }
      head = previous;
    }


  }


  Consumer<String> sout = System.out::println;

  void display() {
    if (head == null) {
      sout.accept("List is empty");
    } else {
      Node<T> current = head;
      while (current != null) {
        sout.accept(current.data + " ");
        current = current.next;

      }
    }

  }

}
