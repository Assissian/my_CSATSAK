package com.atcwl.mvc;

public class Week12 {
    public static void main(String[] args) {
//        int[] values = new int[]{1,2,3,4,5};
//        ListNode head = init(values);
//        head = reverseList(head);
//        while(head!=null) {
//            System.out.println(head.getVal());
//            head = head.getNext();
//        }
        int[] val1 = new int[]{1,2,1};
        int[] val2 = new int[]{1,3,4};
        ListNode l1 = init(val1);
        ListNode l2 = init(val2);
        judgePalindrome(l1);
//        ListNode listNode = mergeList(l1, l2);
//        while(listNode != null){
//            System.out.println(listNode.getVal());
//            listNode = listNode.getNext();
//        }
    }

    public static ListNode init(int[] values) {
        ListNode head = null;
        ListNode next = null;
        ListNode pre = null;
        for (int i = 0; i < values.length; i++) {
            next = new ListNode(values[i]);
            if(head == null) {
                head = next;
                pre = head;
            }else {
                pre.setNext(next);
                pre = next;
            }
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = head, cur = head.getNext(), next = cur.getNext();
        while(next != null) {
            cur.setNext(pre);
            pre = cur;
            cur = next;
            next = next.getNext();
            cur.setNext(pre);
        }
        head.setNext(null);
        return cur;
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while(l1 != null && l2 != null) {
            if(l1.getVal() >= l2.getVal()){
                temp.setNext(l2);
                l2 = l2.getNext();
            }
            else {
                temp.setNext(l1);
                l1 = l1.getNext();
            }
            temp = temp.getNext();
        }
        if(l1 != null)
            temp.setNext(l1);
        if(l2 != null)
            temp.setNext(l2);
        return (newList = newList.getNext());
    }

    public static void judgePalindrome(ListNode head) {
        ListNode temp = head;
        String s1 = "";
        String s2 = "";
        while(head != null){
            s1 = s1 + head.getVal();
            head = head.getNext();
        }
        ListNode tail = reverseList(temp);
        while(tail != null){
            s2 = s2 + tail.getVal();
            tail = tail.getNext();
        }
        System.out.println(s1.equals(s2));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}