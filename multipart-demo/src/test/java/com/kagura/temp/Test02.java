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

        ListNode(int x) {
            val = x;
        }

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
            if(x < 0) return false;
            if(x == 0) return true;
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

    


}
