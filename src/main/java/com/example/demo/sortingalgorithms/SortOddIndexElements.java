package com.example.demo.sortingalgorithms;

import java.util.Arrays;

public class SortOddIndexElements {


  public static void main(String[] args) {
    int[] input = new int[]{0, 30, 2, 70, 5, 15, 1, 10};

    quickSort(input, 1, input.length - 1);

    System.out.println(Arrays.toString(input));

  }

  private static void quickSort(int[] input, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      int pivot = partition(input, startIndex, endIndex);
      quickSort(input, startIndex, pivot - 2);
      quickSort(input, pivot + 2, endIndex);
    }
  }

  private static int partition(int[] input, int startIndex, int endIndex) {
    int i = startIndex - 2;
    int pivot = input[endIndex];

    for (int j = startIndex; j < endIndex; j = j + 2) {

      if (input[j] < pivot) {
        i = i + 2;

        if (i != j) {
          swap(input, i, j);
        }
      }

    }
    swap(input, i + 2, endIndex);

    return i + 2;
  }


  private static void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }


}



