package com.kagura.arithmetic;

import org.junit.Test;

/**
 * 求最大值
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/7 13:05
 * @since 1.0.0
 */
public class Max {

    /**
     * 递归求最大
     */
    @Test
    public void test01() {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.err.println(getMax(arr, 0, arr.length - 1));
    }
    public int getMax(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) {
            return arr[leftIdx];
        }
        int mid = (leftIdx + rightIdx) / 2;
        int maxLeft = getMax(arr, leftIdx, mid);
        int maxRight = getMax(arr, mid + 1, rightIdx);
        return Math.max(maxLeft, maxRight);
    }





}
