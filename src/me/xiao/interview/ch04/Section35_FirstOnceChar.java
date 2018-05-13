package me.xiao.interview.ch04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/13 23:27
 */

public class Section35_FirstOnceChar {
    public static void main(String[] args) {
        System.out.println(new Section35_FirstOnceChar().firstNotRepeating("aabccdbd"));
    }

    private char firstNotRepeating(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -2);
            } else {
                map.put(c, i);
            }
        }

        int idx = Integer.MAX_VALUE;
        char res = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }
}
