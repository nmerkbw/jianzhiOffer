package com.jxs.printListTailToHead;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jiangxs on 2018/7/2.
 */
public class PrintListTailToHead {

    private class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 思路：利用栈的后入先出原则，将结点装到栈中，然后将栈中的值一次存入list中
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    // 思路：采用递归的方式一直访问到最后一个结点，然后从最后一个结点开始，将值装载到
    // list中来实现
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            // addAll可以按照指定 collection 的迭代器所返回的元素顺序，
            // 将该 collection 中的所有元素添加到此列表的尾部。
            list.addAll(printListFromTailToHead2(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }

    @Test
    public void test() {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        PrintListTailToHead ptt = new PrintListTailToHead();
        System.out.println("方法1：" + ptt.printListFromTailToHead1(listNode));
        System.out.println("方法2：" + ptt.printListFromTailToHead2(listNode));

    }
}
