package me.xiao.interview;

/**
 * 单例模式
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 13:22
 */

public class Section02_Singleton {
    public static void main(String[] args) {
        System.out.println(Section02_Singleton.getInstance() == Section02_Singleton.getInstance());
        System.out.println(Section02_SingletonEnum.INSTANCE == Section02_SingletonEnum.INSTANCE);
    }

    public static Section02_Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final Section02_Singleton instance = new Section02_Singleton();
    }
}

