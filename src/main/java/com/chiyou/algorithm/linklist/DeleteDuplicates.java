package com.chiyou.algorithm.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * @author chiyou
 * @Description
 * @create 2023-02-03
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> exist = new ArrayList<>();
        head = findDuplicates(exist,head);
        return head;
    }

    //没有注意到已排序，暂时逻辑校验没有排序，保留第一次出现的
    private ListNode findDuplicates(List<Integer> exist, ListNode head) {
        if (head == null) {
            return null;
        }
        if (exist.contains(head.val)) {
            return findDuplicates(exist,head.next);
        } else {
            exist.add(head.val);
            head.next = (findDuplicates(exist,head.next));
        }
        return head;
    }

    //案例版本
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        head.next = deleteDuplicates(head.next);
//        if(head.val == head.next.val) head = head.next;
//        return head;
//    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1,1,2,4,5,5,4,5});
        System.out.println(listNode.getNext());
        ListNode result = new DeleteDuplicates().deleteDuplicates(listNode.getNext());
        System.out.println(result);
    }
}
