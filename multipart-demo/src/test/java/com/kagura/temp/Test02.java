package com.kagura.temp;

import lombok.ToString;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/11/2
 * @since 1.0.0
 */
public class Test02 {


    static class Solution07 {
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


}
