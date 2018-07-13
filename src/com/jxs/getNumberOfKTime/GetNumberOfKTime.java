package com.jxs.getNumberOfKTime;

public class GetNumberOfKTime {

    public int getNumberOfK(int [] array , int k) {

        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                cnt++;
            } else if (array[i] > k) {
                break;
            }
        }
        return cnt;
    }
}
