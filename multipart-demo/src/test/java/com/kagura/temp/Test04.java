package com.kagura.temp;

import java.util.*;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2022/6/14
 * @since 1.0.0
 */
public class Test04 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution20220614 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 1; i <= size; i++) {
                    TreeNode node = deque.removeFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    if (i == size) result.add(node.val);
                }
            }
            return result;
        }
    }

    class Solution202206142246 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return result;
            f(root, 0);
            return result;
        }
        public void f(TreeNode node, int depth) {
            if (node == null) return;
            // 如果当前节点是在当前深度第一次出现的，就加入到结果集中。
            if (depth == result.size()) result.add(node.val);
            // 当前深度加1（由于是基础类型，回溯时自然再栈中变回原来的数，很巧妙回到上层计数）
            depth++;
            f(node.right, depth);
            f(node.left, depth);
        }

    }

    class Solution202206142259 {
        public int numDistinct(String s, String t) {
            // s => i
            // t => j
            return f(s, t, 0, 0);
        }
        public int f(String s, String t, int i, int j) {
            if (i >= s.length() && j < t.length()) return 0;
            if (j == t.length()) return 1;
            int a = 0, b = 0;
            if (s.charAt(i) == t.charAt(j)) {
                // 可以选择
                a = f(s, t, i + 1, j + 1);
            }
            b = f(s, t, i + 1, j);
            return a + b;
        }
    }

    class Solution202206142319 {
        public int numDistinct(String s, String t) {
            // s => i
            // t => j
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int[] ints : dp) Arrays.fill(ints, -1);
            return f(s, t, 0, 0, dp);
        }
        public int f(String s, String t, int i, int j, int[][] dp) {
            if (i >= s.length() && j < t.length()) return 0;
            if (j == t.length()) return 1;
            if(dp[i][j] != -1) return dp[i][j];
            int a = 0, b = 0;
            if (s.charAt(i) == t.charAt(j)) {
                // 可以选择
                a = f(s, t, i + 1, j + 1, dp);
            }
            b = f(s, t, i + 1, j, dp);
            dp[i][j] = a + b;
            return dp[i][j];
        }
    }


}
