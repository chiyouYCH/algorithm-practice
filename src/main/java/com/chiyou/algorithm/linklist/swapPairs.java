package com.chiyou.algorithm.linklist;

import javax.swing.*;

/**
 * 两两交换链表中的节点
 * 题目；给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author chiyou
 * @Description
 * @create 2022-03-14
 */
public class swapPairs {

    //TODO未实现 本题最好还是用递归
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

    //20220719复习
    public ListNode swapPairs0719(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = head.next;

        ListNode child = swapPairs0719(newNode.next);

        newNode.next = head;
        newNode.next.next=child;

        return newNode;
    }
    //20221103复习
    //分析：1.结束条件，链表结束 2.返回什么，返回头节点 3.方法需要做什么：传入交换两个节点位置
    public ListNode swapPairs1103(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode child = swapPairs1103(head.next.next);
        ListNode newNode = head.next;
        newNode.next = head;
        newNode.next.next = child;

        return newNode;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode.setVal(1);
        listNode1.setVal(2);
        listNode3.setVal(3);
        listNode4.setVal(4);
        listNode5.setVal(5);
        listNode4.setNext(listNode5);
        listNode3.setNext(listNode4);
        listNode1.setNext(listNode3);
        listNode.setNext(listNode1);
        swapPairs reverseList = new swapPairs();
        System.out.println(listNode.toString());
//        System.out.println(reverseList.swapPairs0719(listNode).toString());
        System.out.println(reverseList.swapPairs1103(listNode).toString());
    }
}
