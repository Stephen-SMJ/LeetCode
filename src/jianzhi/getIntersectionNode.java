package jianzhi;

public class getIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    ListNode getIntersectionNode(ListNode headA, ListNode headB) { //双指针之浪漫相遇
        ListNode a = headA, b = headB;
        while (a != b){ //如果没有公共节点，则ab最后都会指向null，所以null是公共节点
            a = a != null? a.next : headB; //总长度 = a.length + b.length， 因此一定会走到同一个节点。
            b = b != null? b.next : headA;
        }
        return a;
    }
}
