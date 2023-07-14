package template;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /*
    链表删除时用pre删除，只需要pre.next = cur.next，不需要再让cur.next = null，否则的话接下来cur = cur.next =null了。
    通常来说有三种方法：
    1.虚拟头+双指针（推荐）注意最后return 虚拟头的next
    2.双指针 （推荐），麻烦的地方是要提前写个判断，一开始需要让head指向第一个不为val的节点。
    3.单指针（逻辑有点绕，不推荐）
     */
}
class dummyHead {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
class doublePointer {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next; //保证头结点不是val
        if (head == null)
            return head;
        ListNode current = head.next;
        ListNode pre = head;
        while(current != null){
            if (current.val == val){
                pre.next = current.next;
            }else{
                pre = current;
            }
            current = current.next;
        }
        return head;

    }
}

class singlePointer {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next; //保证头结点不是val
        if (head == null || head.next==null)
            return head;
        ListNode current = head;
        while(current != null){
            while(current.next != null && current.next.val==val){
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
