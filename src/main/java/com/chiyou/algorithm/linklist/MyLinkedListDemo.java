package com.chiyou.algorithm.linklist;

/**
 * @author chiyou
 * @Description
 * @create 2022-03-10
 */
public class MyLinkedListDemo {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;

    //初始化链表
    public MyLinkedListDemo() {
        size = 0;
        head = new ListNode(0);
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    //获取第index个节点的数值
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    public static void main(String[] args) {
        MyLinkedListDemo myLinkedList = new MyLinkedListDemo();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.get(1);            //返回2
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(myLinkedList.getHead().toString());
        System.out.println(myLinkedList.get(1));     //返回3



        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.addAtHead(5);
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.addAtIndex(2,6);
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.getHead().toString());
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.getHead().toString());

    }
}
