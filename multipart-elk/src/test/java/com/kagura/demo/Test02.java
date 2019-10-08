package com.kagura.demo;

import org.junit.Test;

import java.math.BigDecimal;

public class Test02 {

    @Test
    public void test01() {
        int[][] arr = new int[4][4];
        arr[0][0] = 1;
        arr[0][1] = 8;
        arr[0][2] = 5;
        arr[0][3] = 8;
        arr[1][0] = 3;
        arr[1][1] = 1;
        arr[1][2] = 0;
        arr[1][3] = 8;
        arr[2][0] = 5;
        arr[2][1] = 3;
        arr[2][2] = 6;
        arr[2][3] = 4;
        arr[3][0] = 9;
        arr[3][1] = 4;
        arr[3][2] = 1;
        arr[3][3] = 0;
        System.err.println(getMin(arr));

    }

    // 动态规划
    public int getMin(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

}
