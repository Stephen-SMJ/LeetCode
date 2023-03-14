package jianzhi;

public class mergeTwoLists { //java中l1 = l1.next为什么不会动，
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //ListNode mergeList = l1.val > l2.val ? l2:l1;     //这么写为什么会无限循环，debug发现tmp 和 l1, l2 都没变过
        ListNode mergeList = new ListNode(0);
        ListNode tmp = mergeList;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                tmp.next = l2;
                l2 = l2.next;
            }else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        tmp.next = l1 == null? l2:l1;
        return mergeList.next;
    }
    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(8);
        l0.next = l1; l1.next=l2; l2.next = l3;
        ListNode listNode0 = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(9);
        listNode0.next = listNode1; listNode1.next=listNode2; listNode2.next = listNode3;
        ListNode merg = mergeTwoLists(l0, listNode0);
        while (merg != null){
            System.out.println(merg.val);
            merg = merg.next;
        }

    }
    
}
