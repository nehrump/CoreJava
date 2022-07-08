package com.example.demo.problems;


class TestPractice {

    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(2, new ListNode2(3, new ListNode2(4)));
        ListNode2 l2 = new ListNode2(5, new ListNode2(4, new ListNode2(6)));

        ListNode2 l = addTwoNumbers(l1, l2);
        System.out.println(l.toString());
    }


    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {

        return null;
    }
}


class ListNode2 {

    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

