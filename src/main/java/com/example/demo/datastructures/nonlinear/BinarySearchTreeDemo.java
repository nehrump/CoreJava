package com.example.demo.datastructures.nonlinear;


public class BinarySearchTreeDemo {


  public static void main(String[] args) {
    BinarySearchTree<Integer> node = new BinarySearchTree<>();
    node.insert(1);
    node.insert(2);
    node.insert(3);
    node.insert(4);
    node.insert(5);
    node.insert(6);
    node.insert(7);

    preOrder(node.root);
  }

  static <T extends Comparable<T>> void preOrder(BinarySearchTree<T>.Node<T> node) {
    if (node != null) {
      System.out.print(node.data + " ");
      preOrder(node.left);
      preOrder(node.right);
    }

  }

  static <T> void postOrder(Node<T> node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.print(node.data + " ");
    }

  }

  static <T> void inOrder(Node<T> node) {
    if (node != null) {
      inOrder(node.left);
      System.out.print(node.data + " ");
      inOrder(node.right);

    }

  }


}

class Node<T> {

  T data;
  Node<T> left, right;

  Node(T data) {
    this.data = data;
  }


}


class BinarySearchTree<T extends Comparable<T>> {

  Node<T> root;


  void insert(T key) {
    root = insertKey(root, key);
  }

  private Node<T> insertKey(Node<T> root, T key) {
    if (root == null) {
      root = new Node<>(key);

    } else if (root.data.compareTo(key) <= 0) {
      root.left = insertKey(root.left, key);
    } else if (root.data.compareTo(key) > 0) {
      root.right = insertKey(root.right, key);
    }
    return root;

  }

  class Node<T> {

    T data;
    Node<T> left, right;

    Node(T data) {
      this.data = data;
    }


  }

}














