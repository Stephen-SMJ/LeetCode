package jianzhi;


import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Stack;

public class reversePrint {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public int[] reversePrint(ListNode head) {
		ListNode node = head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		node = head;
		int[] arr = new int[count];
		for (int i = count - 1; i >= 0; i--) {
			arr[i] = node.val;
			node = node.next;
		}
		return arr;

	}

	public static int[] reversePrintByStack(ListNode head) {
		ListNode node = head;
		Stack<Integer> arrStack = new Stack<>();
		while (node != null){
			arrStack.push(node.val);
			node = node.next;
		}
		int size = arrStack.size();
		int[] arr = new int[size];
		for (int i=0; i < size; i++){
			arr[i] = arrStack.pop();
		}
		return arr;
	}

	public static void main(String[] args) {
		ListNode Node1 = new ListNode(1);
		ListNode Node2 = new ListNode(2);
		ListNode Node3 = new ListNode(3);
		Node1.next = Node2;
		Node2.next = Node3;


		System.out.println(Arrays.toString(reversePrint.reversePrintByStack(Node1)));

	}

}
