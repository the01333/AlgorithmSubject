package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 手写 LRU 缓存
 * @Author: YCcLin
 * @Date: 2025/10/13 14:53
 */
public class NO_146 {
    public static void main(String[] args) {
        // [null, null, null, 1, null, -1, null, -1, 3, 4]
//        LRUCacheWithBuiltInLibrary cache = new LRUCacheWithBuiltInLibrary(2);
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/**
 * 手动实现 LRU（implements by 双向链表）
 */
class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    // 维护指针（一开始首尾相连）
    private final Node dummy = new Node(0, 0);
    // 维护值
    private final Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        // 获取后会把节点放到链表头部
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        // 如果存在直接更新
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        // 如果不存在需要直接创建并头插处理指针
        node = new Node(key, value);
        cache.put(key, node);
        pushFront(node);

        // 超出容量需要删除最早未被使用的（即尾部）
        if (cache.size() > capacity) {
            Node lastNode = dummy.prev;
            cache.remove(lastNode.key);
            remove(lastNode);
        }
    }

    /**
     * 每次获取都会重新放到链表头部（本质就是先删后头插）
     *
     * @param key
     * @return
     */
    private Node getNode(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        // 先删再头插
        Node node = cache.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    /**
     * 移除节点
     *
     * @param x
     */
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    /**
     * 头插法
     *
     * @param x
     */
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.next.prev = x;
        x.prev.next = x;
    }
}

/**
 * 内置库实现 LRU
 */
class LRUCacheWithBuiltInLibrary {
    private final int capacity;
    // 内置 LRU, 每次存入都会放入尾部
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCacheWithBuiltInLibrary(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取时无论是否存在, 都先放到”顶部“
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // 利用返回值判断是否存在
        Integer value = cache.remove(key);
        if (value != null) {
            cache.put(key, value);
            return value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.remove(key) != null) {
            cache.put(key, value);
            return;
        }

        // 如果不存在, 要考虑容量是否满（移除最久未使用的）
        if (capacity == cache.size()) {
            Integer targetKey = cache.keySet().iterator().next();
            cache.remove(targetKey);
        }
        cache.put(key, value);
    }
}