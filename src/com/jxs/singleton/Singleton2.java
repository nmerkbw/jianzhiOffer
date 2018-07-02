package com.jxs.singleton;

/**
 * 单例模式————懒汉式1（线程安全），使用synchronized关键字
 * 缺点：①synchronized为重型锁，虽然线程安全，但性能不好
 * ②会出现反射攻击，因为通过 setAccessible()方法
 * 可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象。
 * */
public class Singleton2 {

    // 设置成私有构造器，放置被外部创建实例
    private Singleton2() {

    }

    private static Singleton2 singleton;

    public synchronized Singleton2 getSingleton() {

        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
