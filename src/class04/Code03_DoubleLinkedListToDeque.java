package class04;

import java.util.Deque;
import java.util.LinkedList;

public class Code03_DoubleLinkedListToDeque {

	public static class Node<V> {
		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V v) {
			value = v;
			last = null;
			next = null;
		}
	}

	public static class MyDeque<V> {
		private Node<V> head;
		private Node<V> tail;
		private int size;

		public MyDeque() {
			head = null;
			tail = null;
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return size;
		}

		public void pushHead(V value) {
			Node<V> cur = new Node<>(value);
			if (head == null) {
				head = cur;
				tail = cur;
			} else {
				cur.next = head;
				head.last = cur;
				head = cur;
			}
			size++;
		}

		public void pushTail(V value) {
			Node<V> cur = new Node<>(value);
			if (head == null) {
				head = cur;
				tail = cur;
			} else {
				tail.next = cur;
				cur.last = tail;
				tail = cur;
			}
			size++;
		}

		public V pollHead() {
			V ans = null;
			if (head == null) {
				return ans;
			}
			size--;
			ans = head.value;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.last = null;
			}
			return ans;
		}

		public V pollTail() {
			V ans = null;
			if (head == null) {
				return ans;
			}
			size--;
			ans = tail.value;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				tail = tail.last;
				tail.next = null;
			}
			return ans;
		}

		public V peekHead() {
			V ans = null;
			if (head != null) {
				ans = head.value;
			}
			return ans;
		}

		public V peekTail() {
			V ans = null;
			if (tail != null) {
				ans = tail.value;
			}
			return ans;
		}

	}

	public static void testDeque() {
		MyDeque<Integer> myDeque = new MyDeque<>();
		Deque<Integer> test = new LinkedList<>();
		int testTime = 5000000;
		int maxValue = 200000000;
		System.out.println("测试开始！");
		for (int i = 0; i < testTime; i++) {
			if (myDeque.isEmpty() != test.isEmpty()) {
				System.out.println("Oops!");
			}
			if (myDeque.size() != test.size()) {
				System.out.println("Oops!");
			}
			double decide = Math.random();
			if (decide < 0.33) {
				int num = (int) (Math.random() * maxValue);
				if (Math.random() < 0.5) {
					myDeque.pushHead(num);
					test.addFirst(num);
				} else {
					myDeque.pushTail(num);
					test.addLast(num);
				}
			} else if (decide < 0.66) {
				if (!myDeque.isEmpty()) {
					int num1 = 0;
					int num2 = 0;
					if (Math.random() < 0.5) {
						num1 = myDeque.pollHead();
						num2 = test.pollFirst();
					} else {
						num1 = myDeque.pollTail();
						num2 = test.pollLast();
					}
					if (num1 != num2) {
						System.out.println("Oops!");
					}
				}
			} else {
				if (!myDeque.isEmpty()) {
					int num1 = 0;
					int num2 = 0;
					if (Math.random() < 0.5) {
						num1 = myDeque.peekHead();
						num2 = test.peekFirst();
					} else {
						num1 = myDeque.peekTail();
						num2 = test.peekLast();
					}
					if (num1 != num2) {
						System.out.println("Oops!");
					}
				}
			}
		}
		if (myDeque.size() != test.size()) {
			System.out.println("Oops!");
		}
		while (!myDeque.isEmpty()) {
			int num1 = myDeque.pollHead();
			int num2 = test.pollFirst();
			if (num1 != num2) {
				System.out.println("Oops!");
			}
		}
		System.out.println("测试结束！");
	}

	public static void main(String[] args) {
		testDeque();
	}

}
