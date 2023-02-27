package jianzhi;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		deque.add("o");
		deque.addFirst("A");  // 在前端添加元素 A
		deque.addLast("B");   // 在后端添加元素 B
		deque.addFirst("C");  // 在前端添加元素 C
		deque.addLast("D");   // 在后端添加元素 D

		//C A B D
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeLast());


	}
}
