package com.jxs.findNumsAppearOnce;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/13.
 */
public class FindNumsAppearOnce {

    /**
     * 首先将数组中元素依次异或，因为相同元素异或均为0，最后得到的肯定是两个不相同的数的异或值
     * 然后取这个异或值最右边不为0的位，这个位上肯定是一个数的这一位为1，而另一个数的这一位为0
     *
     * 因为a,b不同，所以异或得到的答案肯定是不等于0的，那么我们就找到a^b的二进制表示中第一个为1的位，
     * 假如是第k位。而a,b两个数在第k位上是不同的，一个为0，一个为1
     * 接下来我们将第k位是1的分成一组，第k位是0的分成一组，如果2个元素相同，那么他们第k位肯定是一样的，所以肯定被分到同一组中。而a,b则被分到2组中去了。
     * 然后分别在各自的数组中异或，由于每个数组中必定只包含了一个不一样数，这样最后异或得到的两个值就是那两个唯一的元素
     * */
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int diff = 0;
        for (int num : array) {
            diff = diff ^ num;
        }
        diff = diff & (-diff);
        for (int num : array) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    @Test
    public void test() {

        int[] array = {1, 1, 2, 3, 3, 4, 5, 5};
        int[] num1 = new int[2];
        int[] num2 = new int[2];
        findNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
