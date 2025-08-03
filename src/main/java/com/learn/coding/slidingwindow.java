package com.learn.coding;

public class slidingwindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int maxSum = findMaxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum);
    }

    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Invalid input: k is larger than array length");
            return -1;
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
