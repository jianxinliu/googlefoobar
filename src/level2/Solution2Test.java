package level2;

import java.util.Arrays;

class Solution2Test {
    public static void main(String[] args) {
        // 3, 6, -1
        int[] solution = Solution2.solution(3, new int[]{1, 4, 7});
        System.out.println(Arrays.toString(solution));

        // 21, 15, 29
        int[] solution2 = Solution2.solution(5, new int[]{19, 14, 28});
        System.out.println(Arrays.toString(solution2));

        // -1, 7, 6, 3
        int[] solution3 = Solution2.solution(3, new int[]{7, 3, 5, 1});
        System.out.println(Arrays.toString(solution3));
    }
}