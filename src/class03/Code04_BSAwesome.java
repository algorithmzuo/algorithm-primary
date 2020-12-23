package class03;

public class Code04_BSAwesome {

	// arr 整体无序
	// arr 相邻的数不相等！
	public static int oneMinIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int N = arr.length;
		if (N == 1) {
			return 0;
		}
		if (arr[0] < arr[1]) {
			return 0;
		}
		if (arr[N - 1] < arr[N - 2]) {
			return N - 1;
		}
		int L = 0;
		int R = N - 1;
		// L...R 肯定有局部最小
		while (L < R - 1) {
			int mid = (L + R) / 2;
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			} else {
				if (arr[mid] > arr[mid - 1]) {
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
		}
		return arr[L] < arr[R] ? L : R;
	}

	// 生成随机数组，且相邻数不相等
	public static int[] randomArray(int maxLen, int maxValue) {
		int len = (int) (Math.random() * maxLen);
		int[] arr = new int[len];
		if (len > 0) {
			arr[0] = (int) (Math.random() * maxValue);
			for (int i = 1; i < len; i++) {
				do {
					arr[i] = (int) (Math.random() * maxValue);
				} while (arr[i] == arr[i - 1]);
			}
		}
		return arr;
	}

	// 也用于测试
	public static boolean check(int[] arr, int minIndex) {
		if (arr.length == 0) {
			return minIndex == -1;
		}
		int left = minIndex - 1;
		int right = minIndex + 1;
		boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
		boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
		return leftBigger && rightBigger;
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maxLen = 100;
		int maxValue = 200;
		int testTime = 1000000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = randomArray(maxLen, maxValue);
			int ans = oneMinIndex(arr);
			if (!check(arr, ans)) {
				printArray(arr);
				System.out.println(ans);
				break;
			}
		}
		System.out.println("测试结束");

	}

}
