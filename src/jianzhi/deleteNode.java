package jianzhi;
public class deleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head;
        }
        ListNode tmp = head.next;
        ListNode former = head;
        while(tmp != null){
            if (tmp.val == val){
                former = tmp.next;
                tmp.next = null;
            }
            tmp = tmp.next;
            former = former.next;
        }

        return head;
    }
}
