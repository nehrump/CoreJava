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

public class QuickSortAlgorithm {

  public static void main(String[] args) {

    int[] input = new int[]{5, 7, 4, 6, 8};

    quickSort(input, 0, input.length - 1);

    System.out.println(Arrays.toString(input));

  }

  private static void quickSort(int[] input, int startIndex, int endIndex) {

    if (startIndex < endIndex) {
      int pi = partition(input, startIndex, endIndex);

      quickSort(input, startIndex, pi - 1);
      quickSort(input, pi + 1, endIndex);
    }


  }

  private static int partition(int[] input, int startIndex, int endIndex) {
    int i = startIndex - 1;
    int pivot = input[endIndex];
    for (int j = startIndex; j < endIndex; j++) {
      if (input[j] < pivot) {
        i++;
        if (i != j) {
          swap(input, i, j);
        }
      }
    }
    swap(input, i + 1, endIndex);

    return i + 1;
  }

  private static void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
