package jianzhi;

public class reverseList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		ListNode temp;
		while(cur!=null){
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
