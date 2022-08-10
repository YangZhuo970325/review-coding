package com.yangzhuo.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {

        // 在构造函数中讲acessOrder设置为true才会实现，在访问的时候将当前访问元素插到队尾
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

        linkedHashMap.put("name1", "aa");
        linkedHashMap.put("name2", "bb");
        linkedHashMap.put("name3", "cc");

        System.out.println(linkedHashMap);

        linkedHashMap.get("name2");

        System.out.println(linkedHashMap);

        LRUCache lruCache = new LRUCache(4);

        lruCache.put("name", "aa");
        lruCache.put("sex", "male");
        lruCache.put("age", "18");
        lruCache.put("hobby", "basketball");

        System.out.println(lruCache);

        lruCache.get("name");

        lruCache.put("friend", "jack");

        System.out.println(lruCache);

    }


}

class LRUCache extends LinkedHashMap {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public String get(String key) {
        return (String)super.get(key);
    }

    public void put(String key, String value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry (Map.Entry eldest) {
        return size() > capacity;
    }
}
