package com.wangboak.leetcode.linklist;

import org.junit.Before;
import org.junit.Test;

/**
 * @program: leetcode->ReverseLinkList
 * @description: 反转链表
 * @author: wangbo4
 * @create: 2020-07-07 00:19
 **/
public class ReverseLinkList {

    public static Integer[] arr = {1, 2, 3, 4, 5};
    public static LinkedNode head;


    @Before
    public void init() {
        head = new LinkedNode(arr[0]);
        LinkedNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new LinkedNode(arr[i]);
            curr = curr.next;
        }
    }

    @Test
    public void printLink() {
        printLink(head);
    }

    public void printLink(LinkedNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    /**
     * 链表反转。遍历法。
     */
    @Test
    public void reverseLink() {
        LinkedNode curr = head;
        LinkedNode pre = null;
        LinkedNode next = null;

        while (true) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            if (curr == null) {
                break;
            }
        }
        printLink(pre);
    }
}
