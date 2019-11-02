package com.kagura.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/6 8:22
 * @since 1.0.0
 */
public class Sort {

    public void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    /**
     * 冒泡排序
     * t O(N)
     * s O(1)
     * - 每次从0开始选择最大的放到最后
     */
    @Test
    public void test01() {
        int[] arr = {8,7,9,2,3,1,4,5,6};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1 && arr[j] > arr[j + 1]; j++) {
                swap(arr, j);
            }
            System.err.println(Arrays.toString(arr));
        }

    }

    /**
     * 插入排序
     * t O(N)
     * s O(1)
     * - 到当前数i的时候，前面的已经排好序了，就像拿着扑克牌，插入到手中的牌
     */
    @Test
    public void test02() {
        int[] arr = {8,7,2,3,1,4,5,6};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j);
            }
            System.err.println(Arrays.toString(arr));
        }
    }

    /**
     * 归并排序 - 写法1
     */
    @Test
    public void test03() {
        int[] arr = {8, 7, 2, 3, 1, 4, 5, 6, 11, 9};
        System.err.println(Arrays.toString(sortProcess(arr, 0, arr.length - 1)));
    }

    public int[] sortProcess(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return new int[]{arr[leftIndex]};
        }
        int mid = (leftIndex + rightIndex) / 2;
        int[] leftArr = sortProcess(arr, leftIndex, mid);
        int[] rightArr =  sortProcess(arr, mid + 1, rightIndex);
        return merge(leftArr, rightArr);
    }

    public static void main(String[] args) {
        int[] leftArr = {2, 3, 7, 8};
        int[] rightArr = {1, 4, 5, 6};
        System.err.println(Arrays.toString(merge(leftArr, rightArr)));
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] h = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, n = 0;
        while ((i != leftArr.length) && (j != rightArr.length)) {
            h[n++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }

        while (i < (leftArr.length)) {
            h[n++] = leftArr[i++];
        }

        while (j < (leftArr.length)) {
            h[n++] = rightArr[j++];
        }

        return h;
    }














}
