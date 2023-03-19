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

    static class Solution202205291102 {
        public static void main(String[] args) {
            Solution202205291102 solution = new Solution202205291102();
            System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code"));
        }
        public int rearrangeCharacters(String s, String target) {
            Map<String, Integer> map1 = new HashMap<>();
            for (int i = 0; i < target.length(); i++) {
                map1.merge(target.charAt(i) + "", 1, Integer::sum);
            }
            Map<String, Integer> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map2.merge(s.charAt(i) + "", 1, Integer::sum);
            }
            int min = -1;
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                // 字符串
                String key = entry.getKey();
                // 对应需要次数
                Integer value = entry.getValue();
                // 存在的次数
                Integer value2 = map2.get(key);
                if (value2 == null) value2 = 0;
                int count = value2 / value;
                if(min == -1) {
                    min = count;
                } else {
                    min = Math.min(min, count);
                }

            }
            return min;
        }
    }

    static class Solution202205291115 {
        public static void main(String[] args) {
            String a = "$1";
            String b = "$2$";
            String c = "3#";
            String d = "$3%";
            System.out.println(a.matches("\\$[0-9]*"));
            System.out.println(b.matches("\\$[0-9]*"));
        }
        public String discountPrices(String sentence, int discount) {
            String[] words = sentence.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.matches("\\$[0-9]+")) {
                    long price = Long.parseLong(word.substring(word.indexOf("$") + 1));
                    double dis = price - price * (discount / 100d);
                    builder.append("$").append(String.format("%.2f", dis));
                } else {
                    builder.append(word);
                }
                if (i != words.length - 1) {
                    builder.append(" ");
                }
            }
            return builder.toString();
        }
    }

    class Solution202205291219 {
        public int minimumObstacles(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (boolean[] booleans : visited) {
                Arrays.fill(booleans, true);
            }
            return f(grid, visited, 0, 0);
        }

        public int f(int[][] grid, boolean[][] visited, int i, int j) {
            if (!visited[i][j]) return grid.length * grid[0].length;
            if (i == grid.length - 1 && j == grid[0].length - 1) return 0;
            visited[i][j] = false;
            int max = grid.length * grid[0].length;
            int a = max , b = max, c = max, d = max;
            // 尝试上 i-1, j
            if (i - 1 >= 0) {
                int top = grid[i - 1][j];
                if (top == 0) {
                    a = f(grid, visited, i - 1, j);
                } else {
                    grid[i - 1][j] = 0;
                    a = f(grid, visited, i - 1, j) + 1;
                    grid[i - 1][j] = 1;
                }
            }
            // 尝试下 i+1, j
            if (i + 1 < grid.length) {
                int top = grid[i + 1][j];
                if (top == 0) {
                    b = f(grid, visited, i + 1, j);
                } else {
                    grid[i + 1][j] = 0;
                    b = f(grid, visited, i + 1, j) + 1;
                    grid[i + 1][j] = 1;
                }
            }
            // 尝试左 i, j+1
            if (j + 1 < grid[0].length) {
                int top = grid[i][j + 1];
                if (top == 0) {
                    c = f(grid, visited, i, j + 1);
                } else {
                    grid[i][j + 1] = 0;
                    c = f(grid, visited, i, j + 1) + 1;
                    grid[i][j + 1] = 1;
                }
            }
            // 尝试右 i, j-1
            if (j - 1 >= 0) {
                int top = grid[i][j - 1];
                if (top == 0) {
                    d = f(grid, visited, i, j - 1);
                } else {
                    grid[i][j - 1] = 0;
                    d = f(grid, visited, i, j - 1) + 1;
                    grid[i][j - 1] = 1;
                }
            }
            visited[i][j] = true;
            int min = Math.min(a, Math.min(b, Math.min(c, d)));
            return min;

        }
    }



    class Solution202205291359 {
        public int minimumObstacles(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (boolean[] booleans : visited) {
                Arrays.fill(booleans, true);
            }
            // [i][j][0] 上
            // [i][j][1] 下
            // [i][j][2] 左
            // [i][j][3] 右
            int[][][] dp = new int[grid.length][grid[0].length][4];
            for (int[][] ints : dp) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, -1);
                }
            }
            return f(grid, visited, 0, 0, dp);
        }

        public int f(int[][] grid, boolean[][] visited, int i, int j, int[][][] dp) {
            if (!visited[i][j]) return grid.length * grid[0].length;
            if (i == grid.length - 1 && j == grid[0].length - 1) return 0;
            visited[i][j] = false;
            int max = grid.length * grid[0].length;
            int a = max , b = max, c = max, d = max;
            // 尝试上 i-1, j
            if (i - 1 >= 0) {
                if (dp[i - 1][j][0] != -1) {
                    a = dp[i - 1][j][0];
                } else {
                    int top = grid[i - 1][j];
                    if (top == 0) {
                        a = f(grid, visited, i - 1, j, dp);
                    } else {
                        grid[i - 1][j] = 0;
                        a = f(grid, visited, i - 1, j, dp) + 1;
                        grid[i - 1][j] = 1;
                    }
                    dp[i - 1][j][0] = a;
                }

            }
            // 尝试下 i+1, j
            if (i + 1 < grid.length) {
                if (dp[i + 1][j][1] != -1) {
                    b = dp[i + 1][j][1];
                } else {
                    int top = grid[i + 1][j];
                    if (top == 0) {
                        b = f(grid, visited, i + 1, j, dp);
                    } else {
                        grid[i + 1][j] = 0;
                        b = f(grid, visited, i + 1, j, dp) + 1;
                        grid[i + 1][j] = 1;
                    }
                    dp[i + 1][j][1] = b;
                }
            }
            // 尝试左 i, j+1
            if (j + 1 < grid[0].length) {
                if (dp[i][j + 1][2] != -1) {
                    c = dp[i][j + 1][2];
                } else {
                    int top = grid[i][j + 1];
                    if (top == 0) {
                        c = f(grid, visited, i, j + 1, dp);
                    } else {
                        grid[i][j + 1] = 0;
                        c = f(grid, visited, i, j + 1, dp) + 1;
                        grid[i][j + 1] = 1;
                    }
                    dp[i][j + 1][2] = c;
                }

            }
            // 尝试右 i, j-1
            if (j - 1 >= 0) {
                if (dp[i][j - 1][3] != -1) {
                    d = dp[i][j - 1][3];
                } else {
                    int top = grid[i][j - 1];
                    if (top == 0) {
                        d = f(grid, visited, i, j - 1, dp);
                    } else {
                        grid[i][j - 1] = 0;
                        d = f(grid, visited, i, j - 1, dp) + 1;
                        grid[i][j - 1] = 1;
                    }
                    dp[i][j - 1][3] = d;
                }
            }
            visited[i][j] = true;
            int min = Math.min(a, Math.min(b, Math.min(c, d)));
            return min;
        }
    }

    class Test001 {
        public boolean makesquare(int[] matchsticks) {
            int side = 0;
            for (int matchstick : matchsticks) side += matchstick;
            if (side % 4 != 0) return false;// 如果不是 4 的倍数，直接 false
            side = side / 4;// 需要的边长
            Arrays.sort(matchsticks);// 排序
            return f(matchsticks, 4, 0, side);
        }
        // 从 nums 中做选择，要求组成到 4 次 side
        // rest 表示剩下可选的
        // n 表示还剩多少边没达标
        // curr 表示当前组合的长度
        // side 表示目标长度
        public boolean f(int[] nums, int n, int curr, int side) {
            if (curr == side) {
                n--;
                curr = 0;
                if (n == 0) return true;
            }
            boolean tf;
            // 每次遍历从『剩余可选数据的头开始』
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) continue;
                int num = nums[i];
                int temp = curr + num;
                // 可以尝试：如果小于等于 side
                // （尝试的时候，就只考虑尝试的事情，不考虑对过程中值的实际处理，实际处理推荐放到 base case 中）
                if (temp <= side) {
                    nums[i] = -1;
                    tf = f(nums, n, temp, side);
                    // 尝试成功
                    if (tf) return true;
                    // 尝试失败
                    nums[i] = num;
                }
                // 不进行尝试
                if (i != 0 && temp > side) break;
            }
            return false;
        }
    }

    class Test002 {
        public boolean makesquare(int[] matchsticks) {
            int side = 0;
            for (int matchstick : matchsticks) side += matchstick;
            if (side % 4 != 0) return false;// 如果不是 4 的倍数，直接 false
            side = side / 4;// 需要的边长
            Arrays.sort(matchsticks);// 排序
            Map<String, Boolean> dp = new HashMap<>();
            return f(matchsticks, 4, 0, side, dp);
        }
        // 从 nums 中做选择，要求组成到 4 次 side
        // rest 表示剩下可选的
        // n 表示还剩多少边没达标
        // curr 表示当前组合的长度
        // side 表示目标长度
        public boolean f(int[] nums, int n, int curr, int side, Map<String, Boolean> dp) {
            if (curr == side) {
                n--;
                curr = 0;
                if (n == 0) return true;
            }
            String key = Arrays.toString(nums);
            if (dp.containsKey(key)) return dp.get(key);
            boolean tf;
            // 每次遍历从『剩余可选数据的头开始』
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) continue;
                int num = nums[i];
                int temp = curr + num;
                // 可以尝试：如果小于等于 side
                // （尝试的时候，就只考虑尝试的事情，不考虑对过程中值的实际处理，实际处理推荐放到 base case 中）
                if (temp <= side) {
                    nums[i] = -1;
                    tf = f(nums, n, temp, side, dp);
                    // 尝试成功
                    if (tf) return true;
                    // 尝试失败
                    nums[i] = num;
                }
                // 不进行尝试
                if (i != 0 && temp > side) break;
            }
            dp.put(key, false);
            return false;
        }
    }






}
