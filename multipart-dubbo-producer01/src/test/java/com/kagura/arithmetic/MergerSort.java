package com.kagura.arithmetic;

import org.junit.Test;

import java.net.*;
import java.util.*;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/9 9:33
 * @since 1.0.0
 */
public class MergerSort {

    public static void main(String[] args) {

        int[] arr = {8,2,3,1,5,4,6,7};

        sort(arr, 0 , arr.length - 1);
        //int[] arr2 = {8, 7};
        //merger(arr2, 0, arr2.length - 1, (arr2.length - 1) / 2);

    }

    public static void sort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return;
        }
        int mid = leftIndex + (rightIndex - leftIndex >> 1);
        sort(arr, leftIndex, mid);
        sort(arr, mid + 1, rightIndex);
        merger(arr, leftIndex, rightIndex, mid);
    }

    public static void merger(int[] arr, int leftIndex, int rightIndex, int mid) {

        int[] temp = new int[rightIndex - leftIndex + 1];
        int i = 0, j = 0, n = 0;
        // 右边数组的起始点
        int k = mid + 1;
        while (i + leftIndex <= mid && (k + j <= rightIndex)) {
            if (arr[leftIndex + i] >= arr[k + j]) {
                temp[n++] = arr[k + j++];
            } else {
                temp[n++] = arr[leftIndex + i++];
            }
        }

        while ((k + j) <= rightIndex) {
            temp[n++] = arr[k + j++];
        }

        while (i + leftIndex <= mid) {
            temp[n++] = arr[leftIndex + i++];
        }

        for (int c = 0; c < temp.length; c++) {
            arr[leftIndex + c] = temp[c];
        }

        System.err.println(Arrays.toString(arr));
    }

}
