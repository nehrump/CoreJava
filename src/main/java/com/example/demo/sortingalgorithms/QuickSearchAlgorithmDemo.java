package com.example.demo.sortingalgorithms;

import java.util.Arrays;


/*
 * 1.Take last element as pivot, 1st element as startIndex,last element before pivot as endIndex
 * 2.Increase startIndex if less than or equal to pivot value until condition fails
 * 3.Decrease endIndex if greater than or equal to pivot value until condition fails
 * 4.Swap values of i and j when condition 2 and 3 fails
 * 5.Repeat step 2 to 4 till i is smaller than j
 * 6.when i value greater than pivot, swap i and pivot
 * */

public class QuickSearchAlgorithmDemo {

  public static void main(String[] args) {

    int[] input = new int[]{5, 8, 24, 7, 24, 4, 12, 6, 9, 1};

    quickSort(input, 0, input.length - 1);

    System.out.println(Arrays.toString(input));

  }

  private static void quickSort(int[] input, int startIndex, int endIndex) {

    if (startIndex < endIndex) {
      int pivotIndex = (startIndex + endIndex) / 2;
      int pivot = input[pivotIndex];
      swap(input, pivotIndex, endIndex);

      int leftPointer = partition(input, startIndex, endIndex, pivot);

      quickSort(input, startIndex, leftPointer - 1);
      quickSort(input, leftPointer + 1, endIndex);

    }

  }

  private static int partition(int[] input, int startIndex, int endIndex, int pivot) {
    int leftPointer = startIndex;
    int rightPointer = endIndex;
    while (leftPointer < rightPointer) {
      while (input[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }

      while (input[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }
      swap(input, leftPointer, rightPointer);
    }
    if (input[leftPointer] > input[endIndex]) {
      swap(input, leftPointer, endIndex);
    }
    return leftPointer;
  }

  private static void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
