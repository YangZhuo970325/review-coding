package com.yangzhuo.collection;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {

    public static void main(String[] args) {

        Map<String, String> table = new Hashtable<String, String>();
        table.put("name", "ss");
        table.put("age", "18");
        table.put("sex", "male");

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("name", "ss");
        hashtable.put("age", "18");
        hashtable.put("sex", "male");

        // hashtable不允许key为null, 也不允许value为null
        // table.put(null, "key不可以为空");
        // table.put("value不可以为空", null);
        traverse1(table);

        traverse2(hashtable);

    }

    // hashmap的遍历方式1: 使用for-each 的 entries遍历
    public static void traverse1(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
        }
    }

    // Enumeration对象遍历
    public static void traverse2(Hashtable<String, String> hashtable) {
        Enumeration e = hashtable.elements();
        while (e.hasMoreElements()) {
            System.out.println("value : " + e.nextElement().toString());
        }
    }


}
