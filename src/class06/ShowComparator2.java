package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShowComparator2 {

	public static class MyComparator implements Comparator<Integer> {

		// 负，第一个参数在前
		// 正，第二个参数在前
		// 0, 谁放前都行
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 < o2) {
				return 1;
			} else if (o1 > o2) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

	// 谁id大，谁放前！
	public static class IdComparator implements Comparator<Student> {

		// 如果返回负数，认为第一个参数应该排在前面
		// 如果返回正数，认为第二个参数应该排在前面
		// 如果返回0，认为谁放前面无所谓
		@Override
		public int compare(Student o1, Student o2) {
			if (o1.id < o2.id) {
				return 1;
			} else if (o2.id < o1.id) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "b";
		System.out.println(str1.compareTo(str2));
		PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
		Student s1 = new Student("张三", 5, 27);
		Student s2 = new Student("李四", 1, 17);
		Student s3 = new Student("王五", 4, 29);
		Student s4 = new Student("赵六", 3, 9);
		Student s5 = new Student("左七", 2, 34);
		heap.add(s1);
		heap.add(s2);
		heap.add(s3);
		heap.add(s4);
		heap.add(s5);
		System.out.println("=========");
		while (!heap.isEmpty()) {
			Student s = heap.poll();
			System.out.println(s.name + ", " + s.id + ", " + s.age);
		}
	}

}
