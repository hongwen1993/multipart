package com.kagura;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache(int capacity) {
        //  false 基于插入顺序
        //  true  基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法）
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     *
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

class Test {
    public static void main(String[] args) {
        LRUCache<String, String> map = new LRUCache<>(3);
        map.put("a", "0");
        map.put("b", "0");
        map.put("c", "0");
        // {a=0, b=0, c=0}
        System.out.println(map);
        map.put("x", "0");
        // {b=0, c=0, x=0}
        System.out.println(map);
        map.get("b");
        // {c=0, x=0, b=0}
        System.out.println(map);
        map.put("y", "0");
        // {x=0, b=0, y=0}
        System.out.println(map);
    }

}
