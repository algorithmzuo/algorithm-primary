package class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HashMapTreeMap {

	public static class Node {
		public int value;

		public Node(int v) {
			value = v;
		}
	}

	// (K V)表
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuochengyun", "我是左程云");
		System.out.println(map.containsKey("zuochengyun"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuochengyun"));

		map.put("zuochengyun", "他是左程云");
		System.out.println(map.get("zuochengyun"));

//		map.remove("zuochengyun");
//		System.out.println(map.containsKey("zuochengyun"));
//		System.out.println(map.get("zuochengyun"));

		String test1 = "zuochengyun";
		String test2 = "zuochengyun";
		System.out.println(map.containsKey(test1));
		System.out.println(map.containsKey(test2));

		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1234567, "我是1234567");

		Integer a = 1234567;
		Integer b = 1234567;

		System.out.println(a == b);
		System.out.println(map2.containsKey(a));
		System.out.println(map2.containsKey(b));

		Node node1 = new Node(1);
		Node node2 = new Node(1);
		HashMap<Node, String> map3 = new HashMap<>();
		map3.put(node1, "我进来了！");
		System.out.println(map3.containsKey(node1));
		System.out.println(map3.containsKey(node2));

		System.out.println("===================");

		TreeMap<Integer, String> treeMap1 = new TreeMap<>();

		treeMap1.put(3, "我是3");
		treeMap1.put(0, "我是3");
		treeMap1.put(7, "我是3");
		treeMap1.put(2, "我是3");
		treeMap1.put(5, "我是3");
		treeMap1.put(9, "我是3");

		System.out.println(treeMap1.containsKey(7));
		System.out.println(treeMap1.containsKey(6));
		System.out.println(treeMap1.get(3));

		treeMap1.put(3, "他是3");
		System.out.println(treeMap1.get(3));

		treeMap1.remove(3);
		System.out.println(treeMap1.get(3));

		System.out.println(treeMap1.firstKey());
		System.out.println(treeMap1.lastKey());
		// <=5 离5最近的key告诉我
		System.out.println(treeMap1.floorKey(5));
		// <=6 离6最近的key告诉我
		System.out.println(treeMap1.floorKey(6));
		// >=5 离5最近的key告诉我
		System.out.println(treeMap1.ceilingKey(5));
		// >=6 离6最近的key告诉我
		System.out.println(treeMap1.ceilingKey(6));

//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		TreeMap<Node, String> treeMap2 = new TreeMap<>();
//		treeMap2.put(node3, "我是node3");
//		treeMap2.put(node4, "我是node4");

	}

}
