package level2;

/**
 * @author jianxinliu
 * @date 2022/07/20 23:01
 */
public class Solution2 {
    public static int[] solution(int h, int[] q) {
        int total = (int) (Math.pow(2, h) - 1);
        int[] ret = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            ret[i] = reverseBinarySearch(total, q[i], h);
        }
        return ret;
    }

    private static int reverseBinarySearch(int root, int target, int h) {
        if (root == target) return -1;
        int right = root - 1;
        int left = right - (int) (Math.pow(2, h - 1) - 1);
        if (left == target || right ==target) {
            return root;
        }
        if (target < left) {
            return reverseBinarySearch(left, target, h - 1);
        }
        if (target < right) {
            return reverseBinarySearch(right, target, h - 1);
        }
        return -1;
    }
}
