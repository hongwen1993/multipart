package com.kagura.temp;

import java.util.*;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2022/5/28
 */
public class Test03 {


    static class Solution202205282230 {
        public static void main(String[] args) {
            Solution202205282230 solution = new Solution202205282230();
            System.out.println(solution.digitCount("1210"));
            System.out.println(solution.digitCount("030"));
        }

        public boolean digitCount(String num) {
            Map<String, Integer> map1 = new HashMap<>();
            for (int i = 0; i < num.length(); i++) {
                String str = num.charAt(i) + "";
                map1.merge(str, 1, Integer::sum);
            }
            boolean tf = true;
            for (int i = 0; i < num.length(); i++) {
                Integer n = map1.get(i + "");
                if(n == null) n = 0;
                Integer m = Integer.parseInt(num.charAt(i) + "");
                if (!Objects.equals(n, m)) tf = false;
            }
            return tf;
        }
    }

    static class Solution202205282238 {
        public static void main(String[] args) {
            Solution202205282238 solution = new Solution202205282238();
            System.out.println(solution.largestWordCount(new String[]{"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"}, new String[]{"Alice","userTwo","userThree","Alice"}));
            System.out.println(solution.largestWordCount(new String[]{"How is leetcode for everyone","Leetcode is useful for practice"}, new String[]{"Bob","Charlie"}));
        }
        public String largestWordCount(String[] messages, String[] senders) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < senders.length; i++) {
                String send = senders[i];
                String message = messages[i];
                int len = message.split(" ").length;
                map.merge(send, len, Integer::sum);
            }
            int max = Integer.MIN_VALUE;
            Set<String> results = new HashSet<>();
            results.add(senders[0]);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    results = new HashSet<>();
                    results.add(entry.getKey());
                } else if (max == entry.getValue()) {
                    results.add(entry.getKey());
                }
            }
            List<String> ans = new ArrayList<>(results);
            Collections.sort(ans);
            return ans.get(ans.size() - 1);
        }
    }


    static class Solution202205282252 {
        public static void main(String[] args) {
            Solution202205282252 solution = new Solution202205282252();
            System.out.println(solution.maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
            System.out.println(solution.maximumImportance(5, new int[][]{{0,3},{2, 4},{1,3}}));
            // 9
            System.out.println(solution.maximumImportance(5, new int[][]{{0,1}}));
            // 3
            System.out.println(solution.maximumImportance(2, new int[][]{{0,1}}));
        }
        public long maximumImportance(int n, int[][] roads) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] road : roads) {
                map.merge(road[0], 1, Integer::sum);
                map.merge(road[1], 1, Integer::sum);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            list.sort((o1, o2) -> o2[1] - o1[1]);
            long sum = 0;
            for (int[] ints : list) {
                sum = sum + (long) ints[1] * n--;
            }
            return sum;
        }
    }

}
