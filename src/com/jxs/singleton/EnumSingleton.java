package com.jxs.singleton;

/**
 * 单例模式———枚举实现单例
 * 目前最安全的实现单例的方法是通过内部静态enum方法来实现，因为jvm会保证enum不能被反射且构造方法只执行一次
 * 单例模式的最佳实践，它实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次。
 */
public class EnumSingleton {

    private EnumSingleton() {

    }

    public static EnumSingleton getSingleton() {

        return Singleton.SINGLETON.getSingleton();
    }


    private enum Singleton {

        SINGLETON;

        private EnumSingleton singleton;

        // JVM会保证此方法绝对只调用一次
        Singleton() {

            singleton = new EnumSingleton();
        }

        public EnumSingleton getSingleton() {

            return singleton;
        }
    }

}
