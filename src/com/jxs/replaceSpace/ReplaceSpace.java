package com.jxs.replaceSpace;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/2.
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {

        char[] strArray = str.toString().toCharArray();
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < strArray.length; i++) {
            char space = ' ';
            if (space == strArray[i]) {
                newStr.append("%20");
            } else {
                newStr.append(strArray[i]);
            }
        }
        return newStr.toString();
    }

    @Test
    public void test() {

        replaceSpace(new StringBuffer("We Are Happy"));
    }
}
