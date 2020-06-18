package com.wayne.algo.ds;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU(Least Recently Used) implemented by inheritance of LinkedHashMap which has accessorder entry.
 *
 * @author wayne.zeng
 * @date 6/18/2020
 */
public class LRUCacheMine<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUCacheMine(int cacheSize) {
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return "LRUCacheMine{" +
                "MAX_CACHE_SIZE=" + MAX_CACHE_SIZE +
                "\nEntries: " + sb.toString() +
                '}';
    }

    public static void main(String[] args) {
        LRUCacheMine lruCacheMine = new LRUCacheMine(3);
        lruCacheMine.put(1, 10);
        lruCacheMine.put(2, 20);
        lruCacheMine.put(3,30);
        System.out.println(lruCacheMine);
        lruCacheMine.get(2);
        System.out.println(lruCacheMine);
        lruCacheMine.put(3, 40);
        System.out.println(lruCacheMine);
        lruCacheMine.put(5, 50);
        System.out.println(lruCacheMine);
    }
}
