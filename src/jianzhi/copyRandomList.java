package jianzhi;

public class copyRandomList {
	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList (Node head){
		if (head == null){
			return null;
		}
		for (Node node = head; node != null; node = node.next.next){  //每次插入了一个node，所以是next.next
			Node newNode = new Node(node.val);
			newNode.next = node.next;
			node.next = newNode;
		}
		for (Node node = head; node != null; node = node.next.next){ //复制random
			Node newNode = node.next;
			newNode.random = (node.random != null) ? node.random.next : null;  // null没有next会报错，所以要先确定random不为bull
		}
		Node newHead = head.next;
		for (Node node = head; node != null; node = node.next){
			Node newNode = node.next;
			node.next = node.next.next;
			newNode.next = (newNode.next != null) ? newNode.next.next : null;
		}
		return newHead;
	}
}
