package com.jxs.string._2_replaceSpace;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/2.
 *
 * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 *
 * 思路：将输入的字符串转换成数组，当检查到数组中的元素为空格时，
 * 使用StringBuilder或者StringBuffer添加"%20"，然后再添加后面不为空格的元素
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {

        if (str == null || str.length() == 0) {
            return "";
        }
        char[] strArray = str.toString().toCharArray();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == ' ') {
                newStr.append("%20");
                continue;
            }
            newStr.append(strArray[i]);
        }
        return newStr.toString();
    }

    @Test
    public void test() {

        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
