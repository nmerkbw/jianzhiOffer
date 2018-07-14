package com.jxs.reverseSentence;

import org.junit.Test;

public class ReverseSentence {

    public String reverseSentence(String str) {

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            } else if (j == chars.length - 1) {
                reverse(chars, i, j);
            }
        }
        reverse(chars, 0, chars.length - 1);
        return sb.append(chars).toString();
    }

    private void reverse(char[] chars, int i, int j) {

        while (i <= j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] chars, int i, int j) {

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void test() {

        String str = "I am a student.";
        System.out.println(reverseSentence(str));
    }
}
