package me.xiao.interview.ch05;

import java.util.LinkedList;

/**
 * 约瑟夫环的问题
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 12:22
 */

public class Section45_JosephCircle {
    public static void main(String[] args) {
        System.out.println(new Section45_JosephCircle().lastRemaining(6, 2));
    }

    private int lastRemaining(int n, int k) {
        if (n < 1 || k < 1) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;

        while (list.size() > 1) {
//            for (int i = 1; i < k; i++) {
//                idx = (idx + 1) % list.size();
//            }

            idx = (idx + k - 1) % list.size();

            list.remove(idx);
        }

        return list.get(0);
    }
}
