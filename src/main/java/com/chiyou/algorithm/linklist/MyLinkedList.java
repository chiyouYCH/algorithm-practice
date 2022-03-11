package com.chiyou.algorithm.linklist;

/** 题目：您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * @author chiyou
 * @Description
 * @create 2022-03-09
 */
public class MyLinkedList {

    public ListNode listNode;

    public MyLinkedList() {

    }

    public int get(int index) {
        int result = -1;
        ListNode cur = new ListNode(-1,listNode);
        for (int i = 0; i <= index; i++) {
            if (cur == null) {
                return -1;
            }
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        listNode = new ListNode(val,listNode);
    }

    public void addAtTail(int val) {
        if (listNode == null) {
            listNode = new ListNode(val,null);
            return;
        }
        ListNode cur = new ListNode();
        while (cur.next != null) {
            cur = listNode.next;
        }
        cur.next = new ListNode(val,null);
    }

    public void addAtIndex(int index, int val) {
        if (index <=0 || listNode == null) {
            addAtHead(val);
            return;
        }
        ListNode cur = listNode;
        ListNode pre = new ListNode(-1,listNode);
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = new ListNode(val,cur);
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        ListNode cur = new ListNode(-1,listNode);
        ListNode pre = new ListNode(-1,listNode);
        for (int i = 0; i <= index; i++) {
            if (cur == null) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next= pre.next.next;
    }

    //分析没有使用长度，仅部分接口实现逻辑，案例见MyLinkedListDemo
    //自己写没有考虑前面加一个虚拟节点，直接使用原生节点

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode3 = new ListNode();
        listNode.setVal(1);
        listNode1.setVal(2);
        listNode3.setVal(3);
        listNode1.setNext(listNode3);
        listNode.setNext(listNode1);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.listNode = listNode;
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(2,6);
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.listNode.toString());
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.listNode.toString());

    }
}
