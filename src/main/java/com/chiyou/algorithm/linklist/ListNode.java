package com.chiyou.algorithm.linklist;

/**
 * @author chiyou
 * @Description
 * @create 2022-03-09
 */

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public int getVal() {
          return val;
     }

     public void setVal(int val) {
          this.val = val;
     }

     public ListNode getNext() {
          return next;
     }

     public void setNext(ListNode next) {
          this.next = next;
     }

     @Override
     public String toString() {
          return "ListNode{" +
                  "val=" + val +
                  ", next=" + next +
                  '}';
     }
}