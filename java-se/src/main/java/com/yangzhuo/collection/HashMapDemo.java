package com.yangzhuo.collection;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "ss");
        map.put("age", "18");
        map.put("sex", "male");
        map.put(null, "key可以为空");
        map.put("value可以为空", null);

        // 遍历
        traverse1(map);
        // traverse2(map);
        // traverse3(map);
        // traverse4(map);

        // 删除map中的元素
        //delEntry(map);
    }



    // hashmap的遍历方式1: 使用for-each 的 entries遍历
    public static void traverse1(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
        }
    }

    // hashmap遍历方式2: 使用for-each 的 keys 或 values遍历
    public static void traverse2(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println("key = " + key);
        }

        for (String value : map.values()) {
            System.out.println("value = " + value);
        }
    }

    // hashmap的遍历方式3: 使用iterator遍历
    public static void traverse3(Map<String, String> map) {

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
        }
    }

    // hashmap的遍历方式4: 使用iterator遍历
    public static void traverse4(Map<String, String> map) {
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
    }

    public static void delEntry(Map<String, String> map) {
        List<String> delKey = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("sex".equals(entry.getKey())) {
                // 直接这样删除会出现 ConcurrentModificationException
                // 原因 ： hashMap使用Iterator进行遍历，next方法中，首先检查expectedModCount和modCount是否相等，如果出现put,remove等操作会修改modCount
                // hashmap: fast-fail  ConcurrentHashMap 和 CopyOnWriteHashMap : fail-safe
                // map.remove(entry.getKey());
                // 解决办法1，存放到一个list中，后续删除
                // 解决办法2，使用concurrentHashMap,会自己检查修改操作
                delKey.add(entry.getKey());
            }
        }
        for (String key : delKey) {
            map.remove(key);
        }
    }

}
