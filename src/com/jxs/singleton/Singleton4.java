package com.jxs.singleton;

/**
 * 单例模式———延迟初始化占位类模式(线程安全)
 * 缺点：①会出现反射攻击，因为通过 setAccessible()方法
 * 可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象。
 * */
public class Singleton4 {

    private static class Singleton4ResourceHolder {

        public static Singleton4 singleton = new Singleton4();
    }

    public Singleton4 getSingleton() {

        return Singleton4ResourceHolder.singleton;
    }
}
