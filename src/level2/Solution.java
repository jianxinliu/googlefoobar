package level2;

import java.util.Arrays;

/**
 * @author jianxinliu
 * @date 2022/07/20 21:53
 */
public class Solution {
    public static String[] solution(String[] l) {
        return Arrays.stream(l).map(Version::new).sorted().map(Version::toString).toArray(String[]::new);
    }

    private static class Version implements Comparable<Version> {
        Integer major;
        Integer minor = -1;
        Integer revision = -1;

        public Version(String v) {
            String[] split = v.split("\\.");
            major = Integer.valueOf(split[0]);
            if (split.length > 1) {
                minor = Integer.valueOf(split[1]);
            }
            if (split.length > 2) {
                revision = Integer.valueOf(split[2]);
            }
        }

        @Override
        public String toString() {
            String ret = "" + major;
            if (minor != -1) {
                ret += "." + minor;
            }
            if (revision != -1) {
                ret += "." + revision;
            }
            return ret;
        }

        @Override
        public int compareTo(Version o) {
            int a = major.compareTo(o.major);
            if (a != 0) {
                return a;
            } else {
                int b = minor.compareTo(o.minor);
                if (b != 0) {
                    return b;
                } else {
                    return revision.compareTo(o.revision);
                }
            }
        }
    }

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
