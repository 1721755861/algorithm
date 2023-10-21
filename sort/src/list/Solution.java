package list;

import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Solution {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;

        System.out.println(node1);

        System.out.println(new Solution().deleteDuplicates(node1).toString());

        System.out.println(node1);


    }

    public ListNode deleteDuplicates(ListNode head) {







        if(head == null || head.next== null)
            return head;
        //dummy：虚伪的东西，这里是伪节点
        //这个是思路时新建了一个链表？没有？
        ListNode dummy = new ListNode(-1);
        dummy.next = head;



        ListNode prev = dummy;

        //head赋值给curr，可是curr改变了head也会跟着改变吗？
        //head再也没有出现了
        ListNode curr = head;

        //循环条件是当前节点和当前节点的next不为空
        while (curr != null && curr.next != null) {
            //当两个节点值相同时，用一个临时节点保存一下【下一个结点】的next值
            //这是为了找到所有相同的节点
            if (curr.val == curr.next.val) {
                ListNode temp = curr.next;
                //因为链表是有序的，所以可以找到所有相同的节点
                while (temp != null && temp.val == curr.val) {
                    temp = temp.next;
                }
                //
                prev.next = temp;
                curr = temp;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        //返回的是dummy的next，所以dummy是什么值不重要
        return dummy.next;
    }
}