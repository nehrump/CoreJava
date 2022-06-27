package com.nehru.datastructures.linear;

import java.util.Comparator;
import java.util.Stack;

public class StackDemo {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2); //insert data to stack
    stack.push(3);

    System.out.println(stack.peek()); //gets top element
    System.out.println(stack.pop()); //removes top element
    System.out.println(stack);
    stack.push(10);
    stack.push(5);
    stack.sort(Comparator.naturalOrder());

    System.out.println(stack);


  }

}
