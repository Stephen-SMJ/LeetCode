package template;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(int x) {
        this.stackIn.push(x);

    }

    public int pop() {
        transToOut();
        return this.stackOut.pop();
    }

    public int peek() {
        transToOut();
        return this.stackOut.peek();
    }

    public void transToOut(){
        if (!this.stackOut.isEmpty()) return;  //不为空的时候才往出栈中put
        while(!this.stackIn.isEmpty()){
            this.stackOut.push(this.stackIn.pop());
        }
    }

    public boolean empty() {
        return this.stackIn.isEmpty() && this.stackOut.isEmpty();
    }

    public static String removeDuplicates(String s) {
        Deque<Character> record= new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            if (record.isEmpty() || record.peek()!=s.charAt(i))
                record.push(s.charAt(i));
            else
                record.pop();
        }

        String res = "";
        while (!record.isEmpty()){
            res += record.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abbaca";
        removeDuplicates(s);
    }
}
