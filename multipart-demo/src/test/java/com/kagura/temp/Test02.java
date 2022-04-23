package com.kagura.temp;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/11/2
 * @since 1.0.0
 */
public class Test02 {


    static class Solution07 {

        // 1->2->4, temp->1->3->4
        // 1->1->2->3->4->4
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode head = new ListNode(0);
            head.next = l2;
            ListNode p1 = l1;
            ListNode p2 = head;
            while (p1 != null && p2.next != null) {
                if (p1.val >= p2.next.val) {
                    p2 = p2.next;
                } else {
                    // (p1.val < p2.next.val)
                    ListNode p1Next = p1.next;
                    ListNode p1Temp = p1;
                    p1.next = p2.next;
                    p2.next = p1;
                    p1 = p1Next;
                    p2 = p1Temp;
                }
            }
            if (p2.next == null) {
                p2.next = p1;
            }
            if (l1.val >= l2.val) {
                return l2;
            } else {
                return l1;
            }
            //return l2;
        }

        public static void main(String[] args) {

            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(4);

            ListNode n4 = new ListNode(1);
            ListNode n5 = new ListNode(3);
            ListNode n6 = new ListNode(4);

            n1.next = n2;
            n2.next = n3;
            n4.next = n5;
            n5.next = n6;

            System.out.println(n1);
            System.out.println(n4);

            ListNode result = Solution07.mergeTwoLists(n1, n4);
            System.out.println(result);
            //System.out.println(n1);
            //System.out.println(n4);


        }

    }

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {val = x;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) sb.append("->").append(next);
            return sb.toString();
        }
    }

    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        // 1->2
        n1.next = n2;
        // 3->4
        n3.next = n4;

        // 1->4
        n1.next = n3.next;
        // 3->1->4
        n3.next = n1;
    }

    // 目标和
    class Solution202111252246 {
        public int findTargetSumWays(int[] nums, int target) {

            return -1;
        }
    }


    static class Solution202112032318 {

        public static void main(String[] args) {
            String[] s = permutation("abc");
            System.out.println(Arrays.toString(s));
            s = permutation("abcdefg");
            System.out.println(Arrays.toString(s));
        }

        static int LEN = 0;

        static Set<String> list = new HashSet<>();

        public static String[] permutation(String s) {
            list.add(s);
            LEN = s.length() - 1;
            myFun(s, LEN);
            return list.toArray(new String[]{});
        }

        static void myFun(String s, int cursor) {

            // 越过左边界
            if (cursor - 1 < 0) {
                myFun(s, LEN);
                return;
            }

            String swap = swap(s, cursor);

            if (list.contains(swap)) {
                return;
            }
            list.add(swap);
            myFun(swap, --cursor);
        }

        static String swap(String s, int cursor) {
            char[] chars = s.toCharArray();
            char current = chars[cursor];
            char next = chars[cursor - 1];
            chars[cursor] = next;
            chars[cursor - 1] = current;
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            return sb.toString();
        }


    }

    static class AllArrangement {


        /**
         * 1234
         * 1243
         * 1423
         * 4123
         * 4132
         * 4312
         * 3412
         * 3421
         * 3241
         * 2341
         * 2314
         * 2134
         */
        static final String S = "abcdefgh";
        static final int LEN = S.length() - 1;
        static List<String> list = new ArrayList<>();

        public static void main(String[] args) {

            list.add(S);
            myFun(S, LEN);
            System.out.println(list);
        }

        static void myFun(String s, int cursor) {

            // 越过左边界
            if (cursor - 1 < 0) {
                myFun(s, LEN);
                return;
            }

            String swap = swap(s, cursor);

            if (list.contains(swap)) {
                return;
            }
            list.add(swap);
            myFun(swap, --cursor);
        }

        static String swap(String s, int cursor) {
            char[] chars = s.toCharArray();
            char current = chars[cursor];
            char next = chars[cursor - 1];
            chars[cursor] = next;
            chars[cursor - 1] = current;
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            return sb.toString();
        }

    }

    static class Solution202112040218 {
        public static void main(String[] args) {
            System.out.println(Arrays.toString(permutation("abcdefgh")));
        }

        @Test
        public void show() {

        }

        public static String[] permutation(String s) {
            char[] chars = s.toCharArray();
            List<Character> rest = new ArrayList<>();
            for (char c : chars) {
                rest.add(c);
            }
            Set<String> result = new HashSet<>();
            choseAppend(rest, result, "");
            return result.toArray(new String[]{});
        }

        public static void choseAppend(List<Character> rest, Set<String> result, String path) {
            if (rest.isEmpty()) {
                result.add(path);
                return;
            }
            for (int i = 0; i < rest.size(); i++) {
                Character c = rest.remove(i);
                choseAppend(rest, result, path + c);
                rest.add(i, c);
            }
        }
    }

    class Solution202112092123 {

        public void reverse(Deque<Integer> stack) {
            if (stack.isEmpty()) return;
            int i = f(stack);
            reverse(stack);
            stack.push(i);
        }

        /**
         * 1. 栈底元素移除掉。
         * 2. 上面的元素盖下来。
         * 3. 返回移除掉的栈底元素。
         */
        public int f(Deque<Integer> stack) {
            int num = stack.pop();
            if (stack.isEmpty()) return num;
            int last = f(stack);
            stack.push(num);
            return last;
        }


    }


    /**
     * 编辑距离
     */
    // 递归
    static class Solution202112091650 {

        public int minDistance(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            return f(chars1, chars2, 0, 0, 0);
        }

        public int f(char[] chars1, char[] chars2, int cur1, int cur2, int n) {
            // base case
            if (cur1 == chars1.length && cur2 != chars2.length) {
                return n + (chars2.length - cur2);
            }
            if (cur1 != chars1.length && cur2 == chars2.length) {
                return n + (chars1.length - cur1);
            }
            if (cur1 == chars1.length && cur2 == chars2.length) {
                return n;
            }
            int max = Math.max(chars1.length, chars2.length);
            int a = max, b = max, c = max, d = max;
            if (chars1[cur1] == chars2[cur2]) {
                // 相同
                a = f(chars1, chars2, cur1 + 1, cur2 + 1, n);
            } else {
                // 不同
                // - 增
                b = f(chars1, chars2, cur1, cur2 + 1, n + 1);
                // - 删
                c = f(chars1, chars2, cur1 + 1, cur2, n + 1);
                // - 改
                d = f(chars1, chars2, cur1 + 1, cur2 + 1, n + 1);
            }
            return Math.min(a, Math.min(b, Math.min(c, d)));
        }

        public static void main(String[] args) {
            Solution202112091650 s = new Solution202112091650();
            System.out.println(s.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        }


    }

    /**
     * 编辑距离
     */
    // 动态规划
    static class Solution202112092223 {

        public int minDistance(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            // 如果不好初始化，比如最终结果可能是任意整型，那就不要用 int[][] 作为 DP Table（缓存表）。
            // 但是 map 可能会超时？
            int[][] dp = new int[chars1.length][chars2.length];
            for (int i = 0; i < chars1.length; i++) {
                for (int j = 0; j < chars2.length; j++) {
                    dp[i][j] = -1;
                }
            }
            return f(chars1, chars2, 0, 0, 0, dp);
        }

        public int f(char[] chars1, char[] chars2, int cur1, int cur2, int n, int[][] dp) {
            // base case
            if (cur1 == chars1.length) {
                return n + (chars2.length - cur2);
            }
            if (cur2 == chars2.length) {
                return n + (chars1.length - cur1);
            }
            //  && n > dp[cur1][cur2]
            if (dp[cur1][cur2] != -1) {
                return dp[cur1][cur2];
            }
            // process
            if (chars1[cur1] == chars2[cur2]) {
                dp[cur1][cur2] = f(chars1, chars2, cur1 + 1, cur2 + 1, n, dp);
            } else {
                int a = f(chars1, chars2, cur1, cur2 + 1, n + 1, dp);
                int b = f(chars1, chars2, cur1 + 1, cur2, n + 1, dp);
                int c = f(chars1, chars2, cur1 + 1, cur2 + 1, n + 1, dp);
                int min = Math.min(a, Math.min(b, c));
                dp[cur1][cur2] = min;
            }

            return dp[cur1][cur2];
        }

        public static void main(String[] args) {
            Solution202112092223 s = new Solution202112092223();
            System.out.println(s.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
        }
    }

    // 先通过二分法找到为止，然后左边找，右边找。
    static class Solution2202112142318 {

        public int search(int[] nums, int target) {
            if (nums.length == 0) return 0;
            int index = getTargetIndex(nums, target);
            if (index == -1) return 0;
            int n = index - 1;
            int count = 1;
            while (n >= 0 && nums[n] == target) {
                count++;
                n--;
            }
            n = index + 1;
            while (n <= nums.length - 1 && nums[n] == target) {
                count++;
                n++;
            }
            return count;
        }

        public int getTargetIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            if (nums[0] > target || nums[right] < target) return -1;
            if (nums[0] == target) return 0;
            if (nums[right] == target) return right;

            while (left <= right) {
                int mid = left + ((right - left) >>> 1);
                int num = nums[mid];
                if (num == target) return mid;
                if (num < target) left = mid + 1;
                if (num > target) right = mid - 1;
            }
            return -1;
        }

        public static void main(String[] args) {
            Solution2202112142318 s = new Solution2202112142318();
            System.out.println(s.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        }
    }

    class Solution202112150009 {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n, s.length()) + s.substring(0, n);
        }
    }

    // X . . X
    // X . . X
    // . . . X
    // . . . .
    class Solution202112181943 {

        // X . . X
        // X . . X
        // . . . X
        // . . . .
        public int countBattleships(char[][] board) {
            int result = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char c = board[i][j];
                    if (c == 'X') {
                        // 每次遇到 X 就开始感染，计数器自增
                        result++;
                        f(board, i, j);
                    }
                }
            }
            return result;
        }

        public void f(char[][] board, int i, int j) {
            if (i == board.length || j == board[0].length || board[i][j] == '.') return;
            // 感染
            if (board[i][j] == 'X') board[i][j] = '.';
            f(board, i + 1, j);
            f(board, i, j + 1);
        }

    }

    static class Solution20211218 {
        public static void main(String[] args) {
            Solution20211218 s = new Solution20211218();
            System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
        }

        public int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            return f(nums, target);
        }

        public int[] f(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) left++;
                if (sum > target) right--;
                if (sum == target) return new int[]{left, right};
            }
            return new int[0];
        }


        public int[] twoSum(int[] nums, int target, int bak) {
            // 空间换时间
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    class Solution202112190148 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    // n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    static class Solution202112191419 {
        public static void main(String[] args) {
            Solution202112191419 s = new Solution202112191419();
            int[][] trust = new int[][]{{1, 3}, {2, 3}};
            System.out.println(s.findJudge(3, trust));

            int[] a = new int[10];
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }

        public int findJudge(int n, int[][] trust) {
            if (n == 1 && trust.length == 0) return 1;
            if (n > 1 && trust.length == 0) return -1;
            if (trust.length == 1) return trust[0][1];
            Map<Integer, Integer> td = new HashMap<>();
            Set<Integer> t = new HashSet<>();
            for (int[] ints : trust) {
                t.add(ints[0]);
                td.merge(ints[1], 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : td.entrySet()) {
                Integer key = entry.getKey();
                if (entry.getValue() == (n - 1) && !t.contains(key)) return key;
            }
            return -1;
        }

        class Solution {
            public int findJudge(int n, int[][] trust, int x) {
                int[] in = new int[n + 1], out = new int[n + 1];
                for (int[] t : trust) {
                    int a = t[0], b = t[1];
                    in[b]++;
                    out[a]++;
                }
                for (int i = 1; i <= n; i++) {
                    if (in[i] == n - 1 && out[i] == 0) return i;
                }
                return -1;
            }
        }
    }

    static class Solution202112212049 {
        public static void main(String[] args) {
            Solution202112212049 solution = new Solution202112212049();
            System.out.println(solution.longestPalindrome("cbbd"));
            ;
        }


        public Set<String> cache = new HashSet<>();

        public String longestPalindrome(String s) {
            f(s, 0, s.length() - 1);
            int max = 0;
            for (String e : cache) {
                if (e.length() > max) {
                    max = e.length();
                    s = e;
                }
            }
            if (cache.size() == 0) return s.charAt(0) + "";
            return s;
        }

        public void f(String s, int left, int right) {
            if (left > right) return;
            boolean tf = true;
            if (s.charAt(left) == s.charAt(right)) {
                int i = left;
                int j = right;
                while (i <= j) {
                    if (s.charAt(i++) != s.charAt(j--)) {
                        tf = false;
                        break;
                    }
                }
                if (tf) {
                    cache.add(s.substring(left, right + 1));
                }
            }
            if (s.charAt(left) != s.charAt(right) || !tf) {
                f(s, left + 1, right);
                f(s, left, right - 1);
            }
        }


        class Solution202112212220 {

            public String maxString = "";

            public String longestPalindrome(String s) {
                boolean[][] dp = new boolean[s.length()][s.length()];
                return f(s, 0, s.length() - 1, dp);
            }

            public String f(String s, int left, int right, boolean[][] dp) {
                if (left > right) return "";
                if (dp[left][right]) return s.substring(left, right + 1);
                if (check(s, left, right)) {
                    if (maxString.length() < right - left + 1) {
                        maxString = s.substring(left, right + 1);
                    }
                } else {
                    f(s, left + 1, right, dp);
                    f(s, left, right - 1, dp);
                }
                // mark visited.
                dp[left][right] = true;
                return maxString;
            }

            public boolean check(String s, int left, int right) {
                while (left < right) {
                    if (s.charAt(left++) != s.charAt(right--)) return false;
                }
                return true;
            }

        }


    }

    class Solution202112222012 {
        public boolean isMatch(String s, String p) {
            return Pattern.matches(p, s);
        }
    }


    // 3
    // ["((()))","(()())","(())()","()(())","()()()"]
    // 1
    // ()
    // 2
    // ()(), (())
    // 3
    // 左边，右边，两边
    static class Solution20211222 {

        public List<String> generateParenthesis(int n) {
            Set<String> set = f(new HashSet<>(), n, 1);
            return new ArrayList<>(set);
        }

        public Set<String> f(Set<String> result, int n, int cur) {
            if (cur > n) return result;
            Set<String> set = new HashSet<>();
            if (cur == 1) {
                set.add("()");
                return f(set, n, cur + 1);
            }
            for (String s : result) {
                for (int i = -1; i <= s.length(); i++) {
                    if (i == -1) set.add("()" + s);
                    if (i == s.length()) set.add(s + "()");
                    if (i != -1 && i != s.length()) set.add(s.substring(0, i) + "()" + s.substring(i));
                }
            }
            return f(set, n, cur + 1);
        }

    }


    static class Solution202112222114 {
        public static void main(String[] args) {
            Solution202112222114 s = new Solution202112222114();
            System.out.println(s.isPalindrome(-111));
            System.out.println(s.isPalindrome(0));
            System.out.println(s.isPalindrome(1));
            System.out.println(s.isPalindrome(12));
            System.out.println(s.isPalindrome(121));
        }

        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x == 0) return true;
            int n = x;
            int result = 0;
            while (n != 0) {
                int a = n % 10;
                n = n / 10;
                result = result * 10 + a;
            }
            return result == x;
        }

        public boolean isPalindrome2(int x) {
            String reverse = (new StringBuilder(x + "")).reverse().toString();
            return (x + "").equals(reverse);
        }
    }


    class Solution202112251506 {
        public boolean isEvenOddTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            int n = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int pre = queue.peek().val;
                pre = n % 2 == 0 ? pre - 1 : pre + 1;
                if (n % 2 == 0) {
                    // 3, 7, 9
                    for (int i = 0; i < size; i++) {
                        TreeNode node = queue.poll();
                        if (node.val % 2 == 0) {
                            return false;
                        }
                        if (i == 0) {
                            pre = node.val;
                        } else if (pre >= node.val) {
                            return false;
                        }
                        pre = node.val;
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                } else {
                    // 10, 4, 2
                    for (int i = 0; i < size; i++) {
                        TreeNode node = queue.poll();
                        if (node.val % 2 == 1) {
                            return false;
                        }
                        if (i == 0) {
                            pre = node.val;
                        } else if (pre <= node.val) {
                            return false;
                        }
                        pre = node.val;
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
                n++;
            }
            return true;
        }
    }


    // 暴力递归
    static class Solution202201290032 {

        public static void main(String[] args) {
            Solution202201290032 solution = new Solution202201290032();
            System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        }

        public int lengthOfLIS(int[] nums) {
            // [10,9,2,5,3,7,101,18]
            return f(nums, 999, nums.length - 1);
        }

        public int f(int[] nums, int pre, int curr) {
            if (curr < 0) return 0;
            // current 可以要，也可以不要。
            // 【不要】任何情况下都可以做的选择。
            // 【要】与上一个『确定要的』作比较，只有小于上一个『确定要的』，才可以做这种选择。
            int b = 0;
            int a = f(nums, pre, curr - 1);
            if (pre > nums[curr]) {
                b = f(nums, nums[curr], curr - 1) + 1;
            }
            return Math.max(a, b);
        }
    }


    static class Solution202201290048 {

        public static void main(String[] args) {
            Solution202201290048 solution = new Solution202201290048();
            System.out.println(solution.lengthOfLIS(new int[]{5, 2, 3, 7, 6}));
            System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        }

        public int lengthOfLIS(int[] nums) {
            // [10,9,2,5,3,7,101,18]
            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);
            return f(nums, 999, nums.length - 1, dp);
        }

        public int f(int[] nums, int pre, int curr, int[] dp) {
            if (curr < 0) return 0;

            int b = 0;
            int a = f(nums, pre, curr - 1, dp);
            if (pre > nums[curr]) {
                if (dp[curr] != -1) return dp[curr];
                b = f(nums, nums[curr], curr - 1, dp) + 1;
                dp[curr] = Math.max(a, b);
            }
            return Math.max(a, b);
        }
    }

    static class Solution202203112016 {
        public static void main(String[] args) {
            Solution202203112016 solution = new Solution202203112016();
            int[][] grid = solution.colorBorder(new int[][]{{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}},
                    1, 3, 1);
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            }
        }

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int[][] target = new int[grid.length][grid[0].length];
            f(grid, row, col, target);
            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < target[0].length; j++) {
                    if (target[i][j] == 1) grid[i][j] = color;
                }
            }
            return grid;
        }

        public void f(int[][] grid, int i, int j, int[][] target) {
            // 上：[i - 1][j]
            // 下：[i + 1][j]
            // 左：[i][j - 1]
            // 右：[i][j + 1]
            // 1. (不越界 && 不相同) || (越界)
            int curr = grid[i][j];
            if ((i - 1 >= 0 && grid[i - 1][j] != curr)
                    || (i + 1 < grid.length && grid[i + 1][j] != curr)
                    || (j - 1 >= 0 && grid[i][j - 1] != curr)
                    || (j + 1 < grid[0].length && grid[i][j + 1] != curr)
                    || (i - 1 < 0 || i + 1 == grid.length || j - 1 < 0 || j + 1 == grid[0].length)) {
                target[i][j] = 1;
            } else {
                target[i][j] = -1;
            }
            // 左递归
            if (j - 1 >= 0 && target[i][j - 1] == 0 && grid[i][j - 1] == curr) f(grid, i, j - 1, target);
            // 上递归
            if (i - 1 >= 0 && target[i - 1][j] == 0 && grid[i - 1][j] == curr) f(grid, i - 1, j, target);
            // 下递归
            if (i + 1 < grid.length && target[i + 1][j] == 0 && grid[i + 1][j] == curr) f(grid, i + 1, j, target);
            // 右递归
            if (j + 1 < grid[0].length && target[i][j + 1] == 0 && grid[i][j + 1] == curr) f(grid, i, j + 1, target);
        }
    }

    static class Solution202203182240 {

        public static void main(String[] args) {
            Solution202203182240 solution = new Solution202203182240();
            //System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
            //System.out.println(solution.maxProduct(new int[]{-2, 3, -2, 4}));
            System.out.println(solution.maxProduct(new int[]{-4, -3, -2}));
        }

        public int maxProduct(int[] nums) {
            if (nums.length == 1) return nums[0];
            return f(nums);
        }
        // [2, 3, -2, 4]
        // [-2, 3, -2, 4]
        // 子序列（i结尾考虑，暴力递归考虑）
        // 以 i 结尾的最大乘积的结果等于什么？
        // - nums[i] > 0，则需要依靠 i - 1 之前的最大乘积  Math.max(max * nums[i], nums[i])
        // - nums[i] < 0，则需要依靠 i - 1 之前的最小乘积  Math.max(min * nums[i], nums[i])

        // 以 i 结尾的最小乘积的结果等于什么？
        // - nums[i] > 0，则需要依靠 i - 1 之前的最小乘积  Math.min(min * nums[i], nums[i]);
        // - nums[i] < 0，则需要依靠 i - 1 之前的最大乘积  Math.min(max * nums[i], nums[i]);
        public int f(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (num > 0) {
                    max = Math.max(max * num, num);
                    min = Math.min(min * num, num);
                }
                if (num < 0) {
                    int temp = max;
                    max = Math.max(min * num, num);
                    min = Math.min(temp * num, num);
                }
                if (num == 0) {
                    max = 0;
                    min = 0;
                }
                result = Math.max(max, result);
            }
            return result;
        }
    }

    class Solution202203190000 {

        public boolean exist(char[][] board, String word) {
            boolean[][] tf = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean ok = f(board, tf, i, j, word, 0);
                    if (ok) return true;
                }
            }
            return false;
        }

        public boolean f(char[][] board, boolean[][] tf, int i, int j, String word, int curr) {
            boolean ok = false;
            if (word.charAt(curr) == board[i][j]) {
                // base case
                if (curr == word.length() - 1) return true;
                tf[i][j] = true;
                // 上  [i - 1][j]
                if (i - 1 >= 0 && !tf[i - 1][j]) {
                    // 前往下个节点搜索前，先将当前节点染色
                    ok = f(board, tf, i - 1, j, word, curr + 1);
                }
                // 下  [i + 1][j]
                if (!ok && i + 1 < board.length && !tf[i + 1][j]) {
                    ok = f(board, tf, i + 1, j, word, curr + 1);
                }
                // 左  [i][j - 1]
                if (!ok && j - 1 >= 0 && !tf[i][j - 1]) {
                    ok = f(board, tf, i, j - 1, word, curr + 1);
                }
                // 右  [i][j + 1]
                if (!ok && j + 1 < board[0].length && !tf[i][j + 1]) {
                    ok = f(board, tf, i, j + 1, word, curr + 1);
                }
                tf[i][j] = false;
                return ok;
            }
            return false;
        }

    }


    class Solution202203192128 {
        public void sortColors(int[] nums) {
            Arrays.sort(nums);
        }
    }

    class Solution202203192132 {
        public void sortColors(int[] nums) {
            // 定义3个计数器（常数级别）
            int zero = 0;
            int one = 0;
            int two = 0;
            for (int num : nums) {
                if (num == 0) zero++;
                if (num == 1) one++;
                if (num == 2) two++;
            }
            int n = 0;
            while (zero-- > 0) nums[n++] = 0;
            while (one-- > 0) nums[n++] = 1;
            while (two-- > 0) nums[n++] = 2;
        }
    }

    class Solution202203192150 {
        public void sortColors(int[] nums) {
            quickSort(0, nums.length - 1, nums);
        }

        public void quickSort(int left, int right, int[] nums) {
            // base case
            if (left >= right) return;
            int pivot = nums[left];
            int cur = left;
            int less = left - 1;
            while (cur <= right) {
                if (nums[cur] < pivot) {
                    int temp = nums[cur];
                    nums[cur] = nums[less + 1];
                    nums[less + 1] = temp;
                    less++;
                }
                cur++;
            }
            if (less == left - 1) less++;
            quickSort(left, less, nums);
            quickSort(less + 1, right, nums);
        }
    }

    static class Solution202203192232 {

        public static void main(String[] args) {
            Solution202203192232 solution = new Solution202203192232();
            solution.oddEvenList(null);
        }

        public ListNode oddEvenList(ListNode head) {
            // 当 node.next.next != null
            // （至少考虑3个节点）

            // 1. 依次修改 odd
            // 2. 依次修改 even
            // 3. odd -> tempEven

            if (head == null) return null;
            // odd 链
            ListNode odd = head;
            // even 链
            ListNode even = head.next;
            ListNode evenTemp = even;
            while (even != null && even.next != null) {
                // 1 -> 2 -> 3 -> 4
                //   ↓↓
                // 1 -> 3 -> 4
                // 2 -> 3 -> 4
                odd.next = even.next;
                // 指针到 next odd
                odd = odd.next;

                // 1 -> 3 -> 4
                // 2 -> 3 -> 4
                //   ↓↓
                // 1 -> 3 -> 4
                // 2 -> 4
                even.next = odd.next;
                // 指针到 next even
                even = even.next;
            }
            // 3. odd -> tempEvent
            odd.next = evenTemp;
            return head;
        }

    }

    static class Solution202203201430 {
        public static void main(String[] args) {
            Solution202203201430 solution = new Solution202203201430();
            System.out.println(solution.numDecodings("17"));
        }
        public int numDecodings(String s) {
            return f(s.toCharArray(), s.length() - 1);
        }
        public int f(char[] chars, int curr) {
            // 226
            if (curr < 0) return 1;
            if (curr == 0 && chars[curr] == '0') return 0;
            if (chars[curr] == '0' && (chars[curr - 1] != '1' && chars[curr - 1] != '2')) return 0;
            int a = 0;
            int b = 0;
            if (chars[curr] != '0') {
                a = f(chars, curr - 1);
            }
            if (curr != 0 && ((chars[curr - 1] == '1') || (chars[curr - 1] == '2' && chars[curr] <= '6'))) {
                // 可以多出一种选择（同时消耗2位）
                b = f(chars, curr - 2);
            }
            return a + b;
        }
    }


    class Solution202203201616 {
        public int numDecodings(String s) {
            int[] dp = new int[s.length()];
            Arrays.fill(dp, -1);
            return f(s.toCharArray(), s.length() - 1, dp);
        }

        public int f(char[] chars, int curr, int[] dp) {
            if (curr < 0) return 1;
            if (curr == 0 && chars[curr] == '0') return 0;
            if (chars[curr] == '0' && (chars[curr - 1] != '1' && chars[curr - 1] != '2')) return 0;
            if (dp[curr] != -1) {
                return dp[curr];
            }
            int a = 0;
            int b = 0;
            if (chars[curr] != '0') {
                a = f(chars, curr - 1, dp);
            }
            if (curr != 0 && ((chars[curr - 1] == '1') || (chars[curr - 1] == '2' && chars[curr] <= '6'))) {
                // 可以多出一种选择（同时消耗2位）
                b = f(chars, curr - 2, dp);
            }
            dp[curr] = a + b;
            return dp[curr];
        }
    }

    static class QuickSortTest202203201940 {

        public static void main(String[] args) {
            QuickSortTest202203201940 c = new QuickSortTest202203201940();
            int[] nums = new int[]{2, 1, 3, 8};
            c.sortArray(nums);
            System.out.println(Arrays.toString(nums));
        }

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int pivot = nums[left];
            int less = left - 1;
            int curr = left;
            while (curr <= right) {
                if (nums[curr] < pivot) {
                    int temp = nums[curr];
                    nums[curr] = nums[less + 1];
                    nums[less + 1] = temp;
                    less++;
                }
                curr++;
            }
            //if (less == left - 1) less++;
            quickSort(nums, left, less);
            quickSort(nums, less + 1, right);
        }
    }


    class Solution202203202247 {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode 头节点副本 = head;
            ListNode 奇数链表当前节点 = head;
            ListNode 偶数链表当前节点 = head.next;
            ListNode 偶数链表节点副本 = head.next;
            while (偶数链表当前节点.next != null) {
                    奇数链表当前节点.next = 偶数链表当前节点.next;
                    奇数链表当前节点 = 偶数链表当前节点.next;
                    偶数链表当前节点.next = 偶数链表当前节点.next.next;
                    偶数链表当前节点 = 偶数链表当前节点.next.next;
            }
            奇数链表当前节点.next = 偶数链表节点副本;
            return 头节点副本;
        }


    }


    static class Solution202203232008 {

        public static void main(String[] args) {
            Solution202203232008 solution = new Solution202203232008();
            System.out.println(solution.divisorGame(4));
        }

        public boolean divisorGame(int n) {
            // 先手胜负
            boolean[] dp = new boolean[n + 2];
            dp[1] = false;
            dp[2] = true;
            for(int i = 3; i <= n; i++) {
                for(int k = 1; k < i; k++){
                    if(i % k == 0 && !dp[i - k]){
                        // k 可以作为一个选择
                        dp[i] = true;
                        break;
                    }
                    dp[i] = false;
                }
            }
            return dp[n];
        }
    }

    static class Solution202203251944 {

        public static void main(String[] args) {
            Solution202203251944 solution = new Solution202203251944();
            System.out.println(solution.trailingZeroes(3));
            System.out.println(solution.trailingZeroes(5));
        }

        public int trailingZeroes(int n) {
            if (n == 0 || n == 1 || n == 2 || n == 3) return 0;
            int two = 0;
            int five = 0;
            for (int i = n; i > 0; i--) {
                int k = i;
                while (k % 2 == 0) {
                    two++;
                    k = k / 2;
                }
                k = i;
                while (k % 5 == 0) {
                    five++;
                    k = k / 5;
                }
            }
            return Math.min(two, five);
        }

    }

    static class Solution202203262103 {
        public static void main(String[] args) {
            Solution202203262103 solution = new Solution202203262103();
            System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"}));
        }
        public int calPoints(String[] ops) {
            if (ops == null || ops.length == 0) return 0;
            Deque<String> list = new LinkedList<>();
            for (String op : ops) {
                switch (op) {
                    case "+":
                        String b = list.removeLast();
                        String a = list.removeLast();
                        list.addLast(a);
                        list.addLast(b);
                        list.addLast((Integer.parseInt(a) + Integer.parseInt(b)) + "");
                        break;
                    case "D":
                        list.addLast((Integer.parseInt(list.getLast()) * 2) + "");
                        break;
                    case "C":
                        list.removeLast();
                        break;
                    default:
                        list.addLast(op);
                        break;
                }
            }
            int sum = 0;
            while (!list.isEmpty()) sum += Integer.parseInt(list.removeFirst());
            return sum;
        }

    }

    static class Solution202203262127 {

        public static void main(String[] args) {
            Solution202203262127 solution = new Solution202203262127();
            System.out.println(solution.lengthOfLongestSubstring("abba"));;
        }

        // s = "abcabcbb"
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    // 千万不能写成 left = map.get(s.charAt(i)) + 1，因为当前重复值可能出现在 left 的左边（之前已经废弃的边界，不影响后续的选择）。
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }

    }


    static class Solution202203262204 {
        public static void main(String[] args) {
            Solution202203262204 solution = new Solution202203262204();
            System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
            System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) return new int[]{};
            Deque<Integer> list = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            // 初始化前 k 个数
            for (int i = 0; i < k && i < nums.length; i++) {
                if (list.isEmpty()) {
                    list.addLast(i);
                    continue;
                }
                while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                    list.removeLast();
                }
                list.addLast(i);
            }
            result.add(nums[list.getFirst()]);
            // 从下标 k 开始滑动
            int left = 0;
            for (int i = k; i < nums.length; i++) {
                // 左边界与最大值校验
                int first = list.getFirst();
                if (first == left) {
                    list.removeFirst();
                }
                // 右边界尝试塞入
                while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                    list.removeLast();
                }
                list.addLast(i);
                // 结果
                result.add(nums[list.getFirst()]);
                // 左边界自增
                left++;
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    class Solution202203270804 {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);
            return f(nums, target, dp);
        }
        public int f(int[] nums, int rest, int[] dp) {
            if (rest < 0) return 0;
            if (rest == 0) return 1;
            if (dp[rest] != -1) return dp[rest];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                sum += f(nums, rest - nums[i], dp);
            }
            dp[rest] = sum;
            return sum;
        }
    }

    class Solution202203282012 {
        public int nthSuperUglyNumber(int n, int[] primes) {

            return -1;
        }
    }

    static class Solution202204022233 {

        public static void main(String[] args) {
            Solution202204022233 solution = new Solution202204022233();
            System.out.println(solution.minBitFlips(10, 7));
        }

        //    1010
        // 1010010
        public int minBitFlips(int start, int goal) {
            String a = Integer.toBinaryString(start);
            String b = Integer.toBinaryString(goal);
            int i = a.length() - 1;
            int j = b.length() - 1;
            int n = 0;
            while (i >= 0 && j >= 0) {
                if (a.charAt(i) != b.charAt(j)) n++;
                i--;
                j--;
            }
            if (a.length() > b.length()) {
                // 算 a 头上几位是0
                while (i >= 0) {
                    if (a.charAt(i) != '0') n++;
                    i--;
                }
            }
            if (a.length() < b.length()) {
                // 算 b 头上几位是0
                while (j >= 0) {
                    if (b.charAt(j) != '0') n++;
                    j--;
                }
            }
            return n;
        }


    }


    static class Solution202204022258 {

        public static void main(String[] args) {
            Solution202204022258 solution = new Solution202204022258();
            System.out.println(solution.triangularSum(new int[]{1, 2, 3, 4, 5}));;
        }

        public int triangularSum(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            return f(list);
        }
        public int f(List<Integer> nums) {
            if (nums.size() == 1) {
                return nums.get(0);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < nums.size(); i++) {
                int mod = (nums.get(i - 1) + nums.get(i)) % 10;
                list.add(mod);
            }
            return f(list);
        }

    }

    static class Solution202204022306 {

        public static void main(String[] args) {
            Solution202204022306 solution = new Solution202204022306();
            System.out.println(solution.numberOfWays("001101"));
        }

        // 先手必然是从 0 开始，到最后 s.length() - 1。
        // 先手确定了，后手必然也是确定的，只不过选择多了。
        public long numberOfWays(String s) {
            if(s.length() < 3) return 0;
            return f(s, 0, -1,0);
        }
        public long f(String s, int curr, int pre, int rest) {
            // 需要考虑
            if (rest != 3 && curr == s.length()) {
                return 0;
            }
            if (rest == 3) {
                return 1;
            }
            long count = 0;
            for (int i = curr; i < s.length(); i++) {
                // 可以做选择
                if (pre == -1 || s.charAt(i) != s.charAt(pre)) {
                    count += f(s, i + 1, i, rest + 1);
                }
            }
            return count;
        }

    }





    static class Solution202204022341 {

        public static void main(String[] args) {
            Solution202204022341 solution = new Solution202204022341();
            System.out.println(solution.numberOfWays("001101"));



        }

        // 先手必然是从 0 开始，到最后 s.length() - 1。
        // 先手确定了，后手必然也是确定的，只不过选择多了。
        public long numberOfWays(String s) {
            if(s.length() < 3) return 0;
            long[][][] dp = new long[s.length()][s.length()][4];
            for (long[][] longs : dp) {
                for (long[] aLong : longs) {
                    Arrays.fill(aLong, -1L);
                }
            }
            return f(s, 0, -1,0, dp);
        }
        public long f(String s, int curr, int pre, int rest, long[][][] dp) {
            // 需要考虑
            if (rest != 3 && curr == s.length()) {
                return 0;
            }
            if (rest == 3) {
                return 1;
            }
            if (pre != -1 && dp[curr][pre][rest] != -1L) {
                return dp[curr][pre][rest];
            }
            long count = 0;
            for (int i = curr; i < s.length(); i++) {
                // 可以做选择
                if (pre == -1 || s.charAt(i) != s.charAt(pre)) {
                    count += f(s, i + 1, i, rest + 1, dp);
                }
            }
            if (pre != -1) {
                dp[curr][pre][rest] = count;
            }
            return count;
        }

    }


    static class Solution202204022351 {

        public static void main(String[] args) {
            Solution202204022351 solution = new Solution202204022351();
            System.out.println(solution.numberOfWays("001101"));



        }

        // 先手必然是从 0 开始，到最后 s.length() - 1。
        // 先手确定了，后手必然也是确定的，只不过选择多了。
        public long numberOfWays(String s) {
            if(s.length() < 3) return 0;
            Map<String, Long> cache = new HashMap<>();
            return f(s, 0, -1,0, cache);
        }
        public long f(String s, int curr, int pre, int rest, Map<String, Long> cache) {
            // 需要考虑
            if (rest != 3 && curr == s.length()) {
                return 0;
            }
            if (rest == 3) {
                return 1;
            }
            String key = curr + "_" + pre + "_" + rest;
            if (cache.get(key) != null) {
                return cache.get(key);
            }
            long count = 0;
            for (int i = curr; i < s.length(); i++) {
                // 可以做选择
                if (pre == -1 || s.charAt(i) != s.charAt(pre)) {
                    count += f(s, i + 1, i, rest + 1, cache);
                }
            }
            cache.put(key, count);
            return count;
        }

    }


    static class Solution202204161543 {

        public static void main(String[] args) {
            Solution202204161543 solution = new Solution202204161543();
            //System.out.println(solution.longestValidParentheses("())()()"));
            System.out.println(solution.longestValidParentheses("()(())"));
        }

        public int longestValidParentheses(String s) {
            if (s == null || s.length() <= 1) return 0;
            // ( ) ) ( ( ) ( ) ) )
            // 0 2 0 0 0 2 0 4 6 0
            // ( ) ( ( ) )
            // 0 2 0 0 2 6
            // 以任意 i 作为节点，向左看
            int[] dp = new int[s.length()];
            dp[0] = 0;
            for (int i = 1; i < s.length(); i++) {
                // 当 c = '(' 时 dp[i] = 0
                // 当 c = ')' 时 进行动态推演
                // （只进行成功配对的逻辑，因为配对失败默认就是0）
                char curr = s.charAt(i);
                if (curr == ')') {
                    char leftChar = s.charAt(i - 1);
                    if (leftChar == '(') dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    if (leftChar == ')') {
                        int pre = i - 1 - dp[i - 1];
                        if (pre >= 0 && s.charAt(pre) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if (pre >= 1) dp[i] += dp[pre - 1];
                        }
                    }
                }
            }
            int max = 0;
            for (int value : dp) max = Math.max(value, max);
            return max;
        }
        public void f() {

        }
    }


    // battle
    // 1
    static class Solution202204162242 {
        public static void main(String[] args) {
            Solution202204162242 solution = new Solution202204162242();
            System.out.println(solution.findClosestNumber(new int[]{2,-1,1}));
        }
        public int findClosestNumber(int[] nums) {
            int minIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (Math.abs(nums[minIndex]) == Math.abs(nums[i])) {
                    if (nums[minIndex] <= nums[i]) {
                        minIndex = i;
                    }
                } else if (Math.abs(nums[minIndex]) > Math.abs(nums[i])) {
                    minIndex = i;
                }
            }
            return nums[minIndex];
        }
    }

    // 2
    static class Solution202204162253 {

        public static void main(String[] args) {
            Solution202204162253 solution = new Solution202204162253();
            // [0] [0, 1, 2]
            // [1] [0, 1]
            // [2] [0]
            System.out.println(solution.waysToBuyPensPencils(20, 10, 5));

        }

        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            if (total < cost1 && total < cost2) return 1;

            return f(total, cost1, cost2);
        }
        public int f(int rest, int cost1, int cost2) {
            if (rest - cost1 < 0 && rest - cost2 < 0) return 0;

            int a = 0, b = 0;
            if (rest - cost1 >= 0) {
                a = f(rest - cost1, cost1, cost2) + 1;
            }
            if (rest - cost2 >= 0) {
                b = f(rest - cost2, cost1, cost2) + 1;
            }
            return a + b;
        }
    }


    static class Solution202204162315 {

        public static void main(String[] args) {
            Solution202204162315 solution = new Solution202204162315();
            // [0] [0, 1, 2]
            // [1] [0, 1]
            // [2] [0]
            System.out.println(solution.waysToBuyPensPencils(1000000, 1, 1));

        }

        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            if (total < cost1 && total < cost2) return 1;
            long[][] dp = new long[total + 1][2];
            for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
            int[] cost = new int[]{cost1, cost2};
            return f(total, cost, 0, dp) + 1;
        }
        public long f(int rest, int[] cost, int pre, long[][] dp) {
            if (rest <= 0) return 0;
            if (dp[rest][pre] != -1) return dp[rest][pre];
            long sum = 0;
            for (int i = pre; i < cost.length; i++) {
                if (rest - cost[i] >= 0) {
                    sum = sum + f(rest - cost[i], cost, i, dp) + 1;
                }
            }
            dp[rest][pre] = sum;
            return sum;
        }
    }


    static class Solution20220417 {
        public static void main(String[] args) {
            Solution20220417 solution = new Solution20220417();
            //System.out.println(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
            System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 10, 5, 20, 5, 10, 5, 5}));
        }

        public boolean lemonadeChange(int[] bills) {
            // [0] 表示5元张数，[1] 表示10元张数。
            int[] count = new int[2];
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    count[0]++;
                } else if (bills[i] == 10) {
                    count[1]++;
                    if (count[0] > 0) {
                        count[0]--;
                    } else {
                        return false;
                    }
                } else if (bills[i] == 20) {
                    if (count[1] >= 1 && count[0] >= 1) {
                        // 10 * 1 + 5 * 1
                        count[1] -= 1;
                        count[0] -= 1;
                    } else if (count[0] >= 3) {
                        // 5 * 3
                        count[0] -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution202204230842 {
        public int[][] outerTrees(int[][] trees) {

            return null;
        }
    }

    static class Solution202204231501 {

        public static void main(String[] args) {
            Solution202204231501 solution = new Solution202204231501();
            int[] time = new int[]{2, 3, 2};
            int[][] fruits = new int[3][2];
            fruits[0][0] = 0;
            fruits[0][1] = 2;
            fruits[1][0] = 1;
            fruits[1][1] = 4;
            fruits[2][0] = 2;
            fruits[2][1] = 1;
            System.out.println(solution.getMinimumTime(time, fruits, 3));

            time = new int[]{1};
            fruits = new int[2][2];
            fruits[0][0] = 0;
            fruits[0][1] = 3;
            fruits[1][0] = 0;
            fruits[1][1] = 5;
            System.out.println(solution.getMinimumTime(time, fruits, 2));

        }

        public int getMinimumTime(int[] time, int[][] fruits, int limit) {
            if (time.length == 0 || fruits.length == 0 || limit == 0) return 0;
            int sum = 0;
            for (int[] fruit : fruits) {
                // type
                int a = fruit[0];
                // need
                int b = fruit[1];
                // limit
                int c = b / limit;
                sum = sum + time[a] * (c + 1);
            }
            return sum;
        }

    }


    static class Solution202204231527 {

        public static void main(String[] args) {
            Solution202204231527 solution = new Solution202204231527();
            int[][] a = new int[][]{{2, 0, 2}, {5, 2, 0}, {4, 1, 0}, {1, 2, 1}, {3, 0, 2}};
            System.out.println(solution.getMaximumNumber(a));
        }

        public int getMaximumNumber(int[][] moles) {
            return -1;
        }
    }


    static class Solution202204231539 {

        public static void main(String[] args) {
            Solution202204231539 solution = new Solution202204231539();
            //System.out.println(solution.conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0}));
            //System.out.println(solution.conveyorBelt(new String[]{">>v",">>v","^<<"}, new int[]{0, 0}, new int[]{1, 0}));
            //System.out.println(solution.conveyorBelt(new String[]{">^^>", "<^v>", "^v^<"}, new int[]{0, 0}, new int[]{1, 3}));

            // > > v
            // ^ > v
            // ^ > v
            // ^ > v
            // ^ ^ <
            //System.out.println(solution.conveyorBelt(new String[]{">>v","^>v","^>v","^>v","^^<"}, new int[]{0, 0}, new int[]{3, 1}));

            System.out.println(solution.conveyorBelt(new String[]{">v","vv"}, new int[]{0, 1}, new int[]{1, 1}));
        }

        public int conveyorBelt(String[] matrix, int[] start, int[] end) {
            int xLen = matrix.length;
            int yLen = matrix[0].length();
            long[][] dp = new long[xLen][yLen];
            for (int i = 0; i < dp.length; i++) {
                long[] ints = dp[i];
                Arrays.fill(ints, -1);
            }
            return (int) f(matrix, end, start[0], start[1], xLen, yLen, new int[xLen][yLen], dp);
        }

        // (new String[]{">v","vv", "vv"}, new int[]{0, 0}, new int[]{2, 1}));
        public long f(String[] matrix, int[] end, int i, int j, int xLen, int yLen, int[][] tf, long[][] dp) {

            if (i == -1 || i == xLen || j == -1 || j == yLen || tf[i][j] == 1) {
                return Integer.MAX_VALUE;
            }
            // 染色
            if (i == end[0] && j == end[1]) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            tf[i][j] = 1;

            char curr = matrix[i].charAt(j);


            // 施法
            // 什么情况下可以施法？
            // 且可以施至少2种法（第1次最多可以施展3种）
            long a1 = Integer.MAX_VALUE;
            long a2 = Integer.MAX_VALUE;
            long a3 = Integer.MAX_VALUE;
            if (curr == '>') {
                // 上，下，左
                // 上
                if (i - 1 >= 0 && tf[i - 1][j] != 1) {
                    a1 = f(matrix, end, i - 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 下
                if (i + 1 <= xLen - 1 && tf[i + 1][j] != 1) {
                    a2 = f(matrix, end, i + 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 左
                if (j - 1 >= 0 && tf[i][j - 1] != 1) {
                    a3 = f(matrix, end, i, j - 1, xLen, yLen, tf, dp) + 1;
                }
            } else if (curr == 'v') {
                // 上，左，右
                // 上

                if (i - 1 >= 0 && tf[i - 1][j] != 1) {
                    a1 = f(matrix, end, i - 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 左
                if (j - 1 >= 0 && tf[i][j - 1] != 1) {
                    a2 = f(matrix, end, i, j - 1, xLen, yLen, tf, dp) + 1;
                }
                // 右
                if (j + 1 <= yLen - 1 && tf[i][j + 1] != 1) {
                    a3 = f(matrix, end, i, j + 1, xLen, yLen, tf, dp) + 1;
                }
            } else if (curr == '<') {
                // 上，下，右
                // 上
                if (i - 1 >= 0 && tf[i - 1][j] != 1) {
                    a1 = f(matrix, end, i - 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 下
                if (i + 1 <= xLen - 1 && tf[i + 1][j] != 1) {
                    a2 = f(matrix, end, i + 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 右
                if (j + 1 <= yLen - 1 && tf[i][j + 1] != 1) {
                    a3 = f(matrix, end, i, j + 1, xLen, yLen, tf, dp) + 1;
                }
            } else if (curr == '^') {
                // 下，左，右
                // 下
                if (i + 1 <= xLen - 1 && tf[i + 1][j] != 1) {
                    a1 = f(matrix, end, i + 1, j, xLen, yLen, tf, dp) + 1;
                }
                // 左
                if (j - 1 >= 0 && tf[i][j - 1] != 1) {
                    a2 = f(matrix, end, i, j - 1, xLen, yLen, tf, dp) + 1;
                }
                // 右
                if (j + 1 <= yLen - 1 && tf[i][j + 1] != 1) {
                    a3 = f(matrix, end, i, j + 1, xLen, yLen, tf, dp) + 1;
                }
            }

            // 不施法
            // 满足条件则不施法继续走：
            long b = Integer.MAX_VALUE;
            if (curr == '>' && j + 1 <= yLen - 1 && tf[i][j + 1] != 1) {
                b = f(matrix, end, i, j + 1, xLen, yLen, tf, dp);
            } else if (curr == 'v' && i + 1 <= xLen - 1 && tf[i + 1][j] != 1) {
                b = f(matrix, end, i + 1, j, xLen, yLen, tf, dp);
            } else if (curr == '<' && j - 1 >= 0 && tf[i][j - 1] != 1) {
                b = f(matrix, end, i, j - 1, xLen, yLen, tf, dp);
            } else if (curr == '^' && i - 1 >= 0 && tf[i - 1][j] != 1) {
                b = f(matrix, end, i - 1, j, xLen, yLen, tf, dp);
            }

            // 恢复现场
            tf[i][j] = 0;
            dp[i][j] = Math.min(a1, Math.min(a2, Math.min(a3, b)));
            return dp[i][j];
        }









    }


}


