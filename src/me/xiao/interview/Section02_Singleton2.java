package me.xiao.interview;

/**
 * 双重检验锁的校检机制
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 13:29
 */

public class Section02_Singleton2 {

    public static void main(String[] args) {
        System.out.println(Section02_Singleton2.getInstance() == Section02_Singleton2.getInstance());
    }

    private volatile static Section02_Singleton2 instance = null;

    public static Section02_Singleton2 getInstance() {
        if (null == instance) {
            synchronized (Section02_Singleton2.class) {
                if (null == instance) {
                    instance = new Section02_Singleton2();
                }
            }
        }
        return instance;
    }
}
