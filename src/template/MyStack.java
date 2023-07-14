package template;

import java.util.LinkedList;

class MyStack {
    LinkedList<Integer> quein;
    LinkedList<Integer>queout;

    public MyStack() {
        this.quein = new LinkedList<>();
        this.queout = new LinkedList<>();
    }

    public void push(int x) {
        queout.offer(x); //offer add at tail, push add at head
        while(!quein.isEmpty()){ //
            queout.offer(quein.poll()); //pop 和 poll一样
        }

        LinkedList<Integer> tmpque = new LinkedList<>();
        tmpque = quein;
        quein = queout;
        queout = tmpque;

    }

    public int pop() {
        return quein.pop();
    }

    public int top() {
        return quein.peek();
    }

    public boolean empty() {
        return quein.isEmpty() && queout.isEmpty();
    }
}
