package com.kagura.temp;

import java.util.Comparator;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2022/3/18 7:30
 * @since 1.0.0
 */
public class SkipList<K, V> {
    private static final double P = 0.25; // 仿照Redis的做法, 维护一个概率值
    private static final int MAX_LEVEL = 32; // 最高层数
    private int size;
    private Comparator<K> comparator;
    /**
     * 有效层数
     */
    private int level;
    /**
     * 不存放任何 K-V 的虚拟头节点
     */
    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        // 头节点的高度必须是跳表的最高层数(非有效层数), 为了后面插入新节点做准备
        first = new Node<>(null, null, MAX_LEVEL);
    }

    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>) k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts; // 该节点的不同层指向的下一节点

        // 拿上面的四层跳表的图来举例
        // first.next[3] == 21节点
        // first.next[2] == 9节点
        // first.next[1] == 6节点
        // first.next[0] == 3节点
        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }
    }
}
