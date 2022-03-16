package com.chiyou.algorithm.linklist;

import javax.swing.*;

/**
 * 题目；给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author chiyou
 * @Description
 * @create 2022-03-14
 */
public class swapPairs {

    //TODO未实现
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        ListNode tmp = head;
        while (next != null) {
            tmp = next.next ;
            next.next = cur;
            cur.next = tmp;
            cur = cur.next;
            next = cur.next;
        }

        return head;
    }

    // 递归版本
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;

        ListNode newNode = swapPairs1(next.next);

        next.next = head;
        head.next = newNode;

        return next;
    }

    // 虚拟头结点
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1,head);
        ListNode next = head;
        ListNode pre = result;
        while (next.next != null) {
            ListNode tmp = next.next.next;
            pre.next = next.next;
            next.next.next = head;
            next.next = tmp;
            pre = pre.next;
            next = pre.next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode3 = new ListNode();
        listNode.setVal(1);
        listNode1.setVal(2);
        listNode3.setVal(3);
        listNode1.setNext(listNode3);
        listNode.setNext(listNode1);
        swapPairs reverseList = new swapPairs();
        System.out.println(listNode.toString());
        System.out.println(reverseList.swapPairs2(listNode).toString());
    }
}
