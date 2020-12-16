package class02;

public class Code02_RandToRand {

	// 此函数只能用，不能修改
	// 等概率返回1~5
	public static int f() {
		return (int) (Math.random() * 5) + 1;
	}

	// 等概率得到0和1
	public static int a() {
		int ans = 0;
		do {
			ans = f();
		} while (ans == 3);
		return ans < 3 ? 0 : 1;
	}

	// 等概率返回0~6
	public static int b() {
		int ans = 0;
		do {
			ans = (a() << 2) + (a() << 1) + a();
		} while (ans == 7);
		return ans;
	}

	// 等概率返回1~7
	public static int c() {
		return b() + 1;
	}

	// 这个结构是唯一的随机机制
	// 你只能初始化并使用，不可修改
	public static class RandomBox {
		private final int min;
		private final int max;

		// 初始化时请一定不要让mi==ma
		public RandomBox(int mi, int ma) {
			min = mi;
			max = ma;
		}

		// 13 ~ 17
		// 13 + [0,4]
		public int random() {
			return min + (int) (Math.random() * (max - min + 1));
		}

		public int min() {
			return min;
		}

		public int max() {
			return max;
		}
	}

	// 利用条件RandomBox，如何等概率返回0和1
	public static int rand01(RandomBox randomBox) {
		int min = randomBox.min();
		int max = randomBox.max();
		// min ~ max
		int size = max - min + 1;
		// size是不是奇数，odd 奇数
		boolean odd = (size & 1) != 0;
		int mid = size / 2;
		int ans = 0;
		do {
			ans = randomBox.random() - min;
		} while (odd && ans == mid);
		return ans < mid ? 0 : 1;
	}

	// 给你一个RandomBox，这是唯一能借助的随机机制
	// 等概率返回from~to范围上任何一个数
	// 要求from<=to
	public static int random(RandomBox randomBox, int from, int to) {
		if (from == to) {
			return from;
		}
		// 3 ~ 9
		// 0 ~ 6
		// 0 ~ range
		int range = to - from;
		int num = 1;
		// 求0～range需要几个2进制位
		while ((1 << num) - 1 < range) {
			num++;
		}

		// 我们一共需要num位
		// 最终的累加和，首先+0位上是1还是0，1位上是1还是0，2位上是1还是0...
		int ans = 0;
		do {
			ans = 0;
			for (int i = 0; i < num; i++) {
				ans |= (rand01(randomBox) << i);
			}
		} while (ans > range);
		return ans + from;
	}

	public static void main(String[] args) {

		int[] count = new int[8]; // 0 1 2 .. 7
		int testTime = 10000000;
		for (int i = 0; i < testTime; i++) {
			int ans = c();
			count[ans]++;
		}

		for (int i = 0; i < 8; i++) {
			System.out.println(i + " : " + count[i]);
		}

//		RandomBox randomBox = new RandomBox(3, 9);
//		int from = 17;
//		int to = 29;
//		int[] ans = new int[to + 1];
//		int testTime1 = 1000000;
//		for (int i = 0; i < testTime1; i++) {
//			ans[random(randomBox, from, to)]++;
//		}
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
//		System.out.println("==========");

	}

}
