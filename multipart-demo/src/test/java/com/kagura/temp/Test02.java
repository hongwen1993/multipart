package com.kagura.temp;

import org.junit.Test;

import java.util.*;

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
        ListNode(int x) { val = x; }

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


}
