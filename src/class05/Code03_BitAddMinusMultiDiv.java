package class05;

// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code03_BitAddMinusMultiDiv {

	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 31; i >= 0; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
			return 1;
		} else if (divisor == Integer.MIN_VALUE) {
			return 0;
		} else if (dividend == Integer.MIN_VALUE) {
			if (divisor == negNum(1)) {
				return Integer.MAX_VALUE;
			} else {
				int ans = div(add(dividend, 1), divisor);
				return add(ans, div(minus(dividend, multi(ans, divisor)), divisor));
			}
		} else {
			return div(dividend, divisor);
		}
	}

}
