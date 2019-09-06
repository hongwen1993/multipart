package com.kagura.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/6 8:22
 * @since 1.0.0
 */
public class Sort {

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
        }
        System.err.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * t O(N)
     * s O(1)
     * - 从后往前看
     */
    @Test
    public void test02() {
        int[] arr = {8,7,9,2,3,1,4,5,6};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j);
            }
        }
        System.err.println(Arrays.toString(arr));
    }

    public void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }




}
