package level3;

class SolutionTest {
    public static void main(String[] args) {
        // 7
//        int count = Solution.solution(new int[][]{
//                new int[]{0, 1, 1, 0},
//                new int[]{0, 0, 0, 1},
//                new int[]{1, 1, 0, 0},
//                new int[]{1, 1, 1, 0},
//        });
//        System.out.println(count);

        // 11
        int count1 = Solution.solution(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0},
        });
        System.out.println(count1);

        // 21
        int count2 = Solution.solution(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 0},
                new int[]{0, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 0},
        });
        System.out.println(count2);
    }
}