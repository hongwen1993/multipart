package com.kagura.arithmetic;

/**
 * 递归求最大最小
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/9 16:30
 * @since 1.0.0
 */
public class RecurveMax {

    public static int max(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + (R - L >> 1);
        int maxLeft = max(arr, L, mid);
        int maxRight = max(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);
    }

    public static int min(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + (R - L >> 1);
        int minLeft = min(arr, L, mid);
        int minRight = min(arr, mid + 1, R);
        return Math.min(minLeft, minRight);
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 20, 5, -6, 2, 5, 8, 0};
        int i = max(arr, 0, arr.length - 1);
        int j = min(arr, 0, arr.length - 1);
        System.err.println("max : " + i);
        System.err.println("min : " + j);
    }

}
