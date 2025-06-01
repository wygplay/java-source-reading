package cn.wygplay.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "wygplay");
        map.put("name", "wygplay2");
    }
}
