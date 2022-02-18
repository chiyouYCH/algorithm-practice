package com.chiyou.algorithm;

import java.util.Arrays;

/**
 * 二分查找   时间复杂度log2(n)
 */
public class BinarySearch {

    public static int search(int[] arr, int seachInt){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start <= end) {
            mid = (end - start)/2 + start;
            if (seachInt == arr[mid]) {
                System.out.println("index :" + mid);
                return mid;
            } else if (seachInt > arr[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = {2,4,6,78,9,56,33,7};
        BinarySearch.search(source,78);
    }
}
