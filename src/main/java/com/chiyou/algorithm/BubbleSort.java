package com.chiyou.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 从大到小
     * @param sourceArrays
     * @return
     */
    public static int[] rightSort(int[] sourceArrays){
        int[] arr = Arrays.copyOf(sourceArrays, sourceArrays.length);

        for(int i = 0;i<arr.length; i++){
            boolean isChange = false;
            for(int j = 0 ;j < arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isChange = true;
                }
            }
            if (!isChange){
                break;
            }
        }
        System.out.println("old arrays:"+Arrays.toString(sourceArrays));
        System.out.println("new arrays:"+Arrays.toString(arr));

        return arr;
    }

    /**
     * 从小到大
     * @param sourceArrays
     * @return
     */
    public static int[] leftSort(int[] sourceArrays){
        int[] arr = Arrays.copyOf(sourceArrays, sourceArrays.length);
        for (int i = 0 ; i < arr.length ; i++){
            boolean isChange = false;

            for(int j = arr.length -1 ;j > 0 ;j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    isChange = true;
                }
            }

            if (!isChange) {
                break;
            }
        }
        System.out.println("old arrays:"+Arrays.toString(sourceArrays));
        System.out.println("new arrays:"+Arrays.toString(arr));


        return arr;
    }

    public static void main(String[] args) {
        int[] oldArrys = {5,4,3,7,2,8,9,11};
        BubbleSort.rightSort(oldArrys);
        BubbleSort.leftSort(oldArrys);

        Arrays.sort(oldArrys);
        System.out.println(Arrays.toString(oldArrys));
    }

}
