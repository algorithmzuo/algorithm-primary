package class02;

public class Code03_EqualProbabilityRandom {

	// 内部内容不可见
	public static int f() {
		return Math.random() < 0.8 ? 0 : 1;
	}

	// 等概率返回0和1
	public static int g() {
		int first = 0;
		do {
			first = f(); // 0 1
		} while (first == f());
		return first;
	}

	// 这个结构是唯一的随机机制
	// 你只能初始化并使用，不可修改
	public static class RandomBox {
		private final double p;

		// 初始化时请一定满足：0 < zeroP < 1
		public RandomBox(double zeroP) {
			p = zeroP;
		}

		public int random() {
			return Math.random() < p ? 0 : 1;
		}

	}

	// 底层依赖一个以p概率返回0，以1-p概率返回1的随机函数rand01p
	// 如何加工出等概率返回0和1的函数
	public static int rand01(RandomBox randomBox) {
		int num;
		do {
			num = randomBox.random();
		} while (num == randomBox.random());
		return num;
	}

	public static void main(String[] args) {
		int[] count = new int[2];// 0 1
		for (int i = 0; i < 1000000; i++) {
			int ans = g();
			count[ans]++;
		}
		System.out.println(count[0] + " , " + count[1]);

//		double zeroP = 0.88;
//		RandomBox randomBox = new RandomBox(zeroP);
//
//		int testTime = 10000000;
//		int count = 0;
//		for (int i = 0; i < testTime; i++) {
//			if (rand01(randomBox) == 0) {
//				count++;
//			}
//		}
//		System.out.println((double) count / (double) testTime);

	}

}
