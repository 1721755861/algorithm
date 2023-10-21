package list;

import basestruct.ListNode;

public class List1 {

    //反转链表
    public ListNode ReverseList(ListNode head) {

        // 提交测试
        if(head == null || head.next == null){
            return head;
        }

        // 思路就是使用临时节点存储各个位上的值，然后依次处理
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 链表是否有环
    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }

        return false;
    }
}
