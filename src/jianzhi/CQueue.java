package jianzhi;

import java.util.Stack;

public class CQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	public CQueue(){

	}

	public void appendTail(int value) {
		this.stack1.push(value); //1 2  // 2 1 -> 1 2

	}

	public int deleteHead() {
		if (!stack2.isEmpty()){ //stack2 !null
			return stack2.pop();
		}
		if (stack1.isEmpty()){ // stack1 null stack2 null
			return -1;
		}
		while (!stack1.isEmpty()){  // stack1 !null  stack2 null
			stack2.push(stack1.pop());
		}
		return stack2.pop();

	}

	public static void main(String[] args) {
		CQueue obj = new CQueue();
		obj.appendTail(1);
		obj.appendTail(2);
		System.out.println(obj.deleteHead());
		System.out.println(obj.deleteHead());


	}
}

