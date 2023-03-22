package com.kagura.temp;

import java.util.*;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2023/3/19
 * @since 1.0.0
 */
public class Test05 {

    public static void main(String[] args) {
        String s = "12";
        int a = 2;

        System.out.println(s);

    }

    static class Solution202303191453 {

        public static void main(String[] args) {
            Solution202303191453 solution = new Solution202303191453();
            System.out.println(solution.findLexSmallestString("5525", 9, 2));


        }

        Map<String, Integer> visited = new HashMap<>();
        List<String> lenList = new ArrayList<>();

        public String findLexSmallestString(String s, int a, int b) {
            f(s, a, b);
            Collections.sort(lenList);
            return lenList.get(0);
        }

        public void f(String s, int a, int b) {
            if (visited.containsKey(s)) {
                return;
            } else {
                visited.put(s, 1);
                lenList.add(s);
            }
            String temp = s;
            // 可以累加 a
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    int oldNum = Integer.parseInt(s.charAt(i) + "");
                    int newNum = oldNum + a;
                    newNum = newNum % 10;
                    s = s.substring(0, i) + newNum + s.substring(i + 1);
                }
            }

            f(s, a, b);
            // 可以右移 b
            s = temp;
            int r = s.length() - b;
            s = s.substring(r) + s.substring(0, r);
            f(s, a, b);
        }

    }

    static class Solution202303230020 {
        public static void main(String[] args) {
            Solution202303230020 solution = new Solution202303230020();
            System.out.println(solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{2}, new int[]{5}));
        }

        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> result = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                Arrays.sort(arr);
                result.add(check(arr));
            }
            return result;
        }
        public boolean check(int[] nums) {
            if (nums.length < 2) {
                return true;
            }
            int minus = nums[1] - nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] != minus) {
                    return false;
                }
            }
            return true;
        }
    }

}
