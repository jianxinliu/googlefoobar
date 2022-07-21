package level2;

class SolutionTest {
    public static void main(String[] args) {
        // 1.0,1.0.2,1.0.12,1.1.2,1.3.3
        String collect1 = String.join(",", Solution.solution(new String[]{"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"}));
        System.out.println(collect1);

        System.out.println();

        // 0.1,1.1.1,1.2,1.2.1,1.11,2,2.0,2.0.0
        String collect = String.join(",", Solution.solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"}));
        System.out.println(collect);
    }
}