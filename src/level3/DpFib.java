package level3;

/**
 * @author jianxinliu
 * @date 2022/07/28 19:24
 */
public class DpFib {
    public static void main(String[] args) {
        System.out.println(dp(10));
        System.out.println(fib(10));
    }

    /**
     * 动态规划法求 fib
     * @param n
     * @return
     */
    public static int dp(int n) {
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        for (int i = 2; i < n; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[n - 1];
    }

    /**
     * 递归法求 fib
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fib(n - 1) + fib(n - 2);
    }
}
