package jianzhi;

public class reverseList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseList(ListNode head) {  //三指针
		ListNode tmp=null;
		ListNode cur = head;
		ListNode prev = null;
		while(cur!=null){
			tmp = cur;
			cur = cur.next;
			tmp.next=prev;
			prev=tmp;
		}
		return prev;
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode current = head.next;
		ListNode pre = head;
		while(current != null){
			if (current.val == val){
				pre.next = current.next;
				current.next = null;
			}
			pre = current;
			current = current.next;
		}
		return head;

	}

	public static void main(String[] args) {


	}
}
