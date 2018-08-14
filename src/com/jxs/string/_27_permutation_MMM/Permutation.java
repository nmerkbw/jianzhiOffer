package com.jxs.string._27_permutation_MMM;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> permutation(String str) {

        if (str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracking(chars,new boolean[chars.length],new StringBuilder());
        return ret;
    }

    private void backTracking(char[] chars, boolean[] hasUsed, StringBuilder s) {

        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backTracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    @Test
    public void test() {

        String str = "";
        ArrayList<String> list = permutation(str);
        System.out.println(list);
    }
}
