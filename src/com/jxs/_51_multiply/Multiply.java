package com.jxs._51_multiply;

import org.junit.Test;

/**
 * +   <-  <- <-
 * ->  +   <- <-
 * -> ->   +  <-
 * -> -> ->    +
 * */
public class Multiply {

    public int[] multiply(int[] A) {

        int n = A.length;
        int[] B = new int[n];
        //int temp = 1;
        for (int i = 0, temp = 1; i < n;  i++) {
            B[i] = temp;
            temp *= A[i];
        }
        for (int i = n - 1, temp = 1; i >= 0;  i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }

    @Test
    public void test() {

        int[] A = {1, 2, 3, 4};
        int[] B = multiply(A);
        for (int n : B) {
            System.out.print(n+" ");
        }
    }
}
