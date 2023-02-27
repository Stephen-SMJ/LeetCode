package jianzhi;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
	LinkedList<Integer> minStack;
	LinkedList<Integer> minStackVal;
	/** initialize your data structure here. */
	public MinStack() {
		minStack = new LinkedList<>();
		minStackVal = new LinkedList<>();
		minStackVal.addLast(Integer.MAX_VALUE);
	}

	public void push(int x) {
		minStack.addLast(x);
		if (!minStackVal.isEmpty()){
			minStackVal.addLast(Math.min(x,minStackVal.peekLast()));
		}
	}

	public void pop() {
		minStack.removeLast();
		minStackVal.removeLast();
	}

	public int top() {
		if (!minStack.isEmpty()){
			return minStack.peekLast();
		}
		return -1;
	}

	public int min() {
		if (!minStackVal.isEmpty()){
			return minStackVal.peekLast();
		}
		return -1;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.min());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.min());
	}
}
