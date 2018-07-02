package com.jxs.singleton;

/**
 * 单例模式————懒汉式2（线程安全），使用双重加锁的方法DCL
 * 缺点：①无竞争同步的执行速度很慢，以及JVM启动时很慢
 * ②会出现反射攻击，因为通过 setAccessible()方法
 * 可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象。
 * */
public class Singleton3 {

    // 设置成私有构造器，放置被外部创建实例
    private Singleton3() {

    }

    private volatile static Singleton3 singleton;

    public Singleton3 getSingleton() {

        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
