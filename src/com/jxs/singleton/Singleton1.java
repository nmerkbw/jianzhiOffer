package com.jxs.singleton;

/**
 * 单例模式————饿汉式（线程安全）
 * 缺点：①直接实例化的方式丢失了延迟实例化带来的节约资源的优势
 * ②会出现反射攻击，因为通过 setAccessible()方法
 * 可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象。
 * */
public class Singleton1 {

    // 设置成私有构造器，放置被外部创建实例
    private Singleton1() {

    }

    private static Singleton1 singleton = new Singleton1();

    public Singleton1 getSingleton() {

        return singleton;
    }
}
