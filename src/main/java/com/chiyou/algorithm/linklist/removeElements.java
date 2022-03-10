package com.chiyou.algorithm.linklist;

/**
 * 题目：给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * @author chiyou
 * @Description
 * @create 2022-03-09
 */
public class removeElements {

    //逻辑能自己梳理，但是自己没有写出来，对链表操作不熟悉
    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(val+1,head);
        ListNode pre = result;
        ListNode cur = head;

        while (cur != null) {
            if (cur.getVal() == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;

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
        ListNode listNode2 = removeElements(listNode, 2);
        System.out.println(listNode2.toString());
    }
}
