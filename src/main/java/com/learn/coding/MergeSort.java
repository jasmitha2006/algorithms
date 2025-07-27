package com.learn.coding;

public class MergeSort {
    public static void main(String[] args) {
            int[] arr = {38, 27, 43, 3, 9, 82, 10};

            System.out.println("Original Array:");
            printArray(arr);

            mergeSort(arr, 0, arr.length - 1);

            System.out.println("\nSorted Array:");
            printArray(arr);
        }

        // Method to perform merge sort on the array
        public static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                // Find the middle point
                int mid = (left + right) / 2;

                // Sort first half
                mergeSort(arr, left, mid);

                // Sort second half
                mergeSort(arr, mid + 1, right);

                // Merge the two halves
                merge(arr, left, mid, right);
            }
        }

        // Method to merge two sorted halves of the array
        public static void merge(int[] arr, int left, int mid, int right) {
            // Sizes of two subarrays to merge
            int size1 = mid - left + 1;
            int size2 = right - mid;

            // Temporary arrays
            int[] leftArray = new int[size1];
            int[] rightArray = new int[size2];

            // Copy data to temp arrays
            for (int i = 0; i < size1; i++)
                leftArray[i] = arr[left + i];
            for (int j = 0; j < size2; j++)
                rightArray[j] = arr[mid + 1 + j];

            // Merge the temp arrays back into the original array
            int i = 0, j = 0, k = left;

            while (i < size1 && j < size2) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i];
                    i++;
                } else {
                    arr[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            // Copy any remaining elements of leftArray
            while (i < size1) {
                arr[k] = leftArray[i];
                i++;
                k++;
            }

            // Copy any remaining elements of rightArray
            while (j < size2) {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }

        // Method to print the array
        public static void printArray(int[] arr) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
