package com.chiyou.algorithm.linklist;

/**
 * 题目：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author chiyou
 * @Description
 * @create 2022-03-11
 */
public class reverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp ;
        while (cur != null) {
            temp  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
        reverseList reverseList = new reverseList();
        System.out.println(listNode.toString());
        System.out.println(reverseList.reverseList(listNode).toString());
    }
}
