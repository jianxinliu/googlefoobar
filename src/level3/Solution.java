package level3;


import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Objects;

/**
 * 当前思路的问题：存在不破墙就不存在到达终点的可能，此时需要破除一堵墙才能到达终点。破墙不仅仅是为了缩短路径，还有可能是为了到达
 * @author jianxinliu
 * @date 2022/07/21 23:00
 */
public class Solution {

    private static int w;
    private static int h;
    private static int[][] map;

    public static int solution(int[][] m) {
        w = m[0].length;
        h = m.length;
        map = m;
        List<Position> path = new LinkedList<>();
        List<Position> path1 = findPath(Position.start(), path);
        return breakPath(path1);
    }

    private static int breakPath(List<Position> path) {
        int ret = path.size();
        for (int i = 1; i < path.size(); i++) {
            Position cur = path.get(i);
            int curLen = path.size();
            for (int j = 0; j < i; j++) {
                Position pre = path.get(j);
                if (cur.isNeighbor(pre)) {
                    curLen = Math.min(curLen, j + 3 + (path.size() - i - 1));
                }
            }
            ret = Math.min(ret, curLen);
        }
        return ret;
    }

    private static List<Position> findPath(Position start, List<Position> path) {
        List<Position> next = start.lookNext(path);
        path.add(start);
        Set<Position> ret = new LinkedHashSet<>(path);
        next.stream()
                .map(n -> findPath(n, path))
                .min((n, a) -> a.size() - n.size())
                .ifPresent(ret::addAll);
        return new ArrayList<>(ret);
    }

    private static boolean isAvailable(Position now) {
        int i = now.i;
        int j = now.j;
        if (i < 0 || j < 0) return false;
        return i < h && j < w && map[i][j] == 0;
    }

    private static class Position {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public static Position start() {
            return new Position(0, 0);
        }

        public boolean isNeighbor(Position another) {
            return (Math.abs(i - another.i) == 2 && j == another.j && map[(i + another.i) / 2][j] == 1)
                    || (Math.abs(j - another.j) == 2 && i == another.i && map[i][(j + another.j) / 2] == 1);
        }

        public Optional<Position> moveRight(List<Position> path) {
            return moveTo(new Position(i + 1, j), path);
        }

        public Optional<Position> moveLeft(List<Position> path) {
            return moveTo(new Position(i - 1, j), path);
        }

        public Optional<Position> moveUp(List<Position> path) {
            return moveTo(new Position(i, j - 1), path);
        }

        public Optional<Position> moveDown(List<Position> path) {
            return moveTo(new Position(i, j + 1), path);
        }

        public List<Position> lookNext(List<Position> path) {
            List<Position> ret = new ArrayList<>(3);
            this.moveRight(path).ifPresent(ret::add);
            this.moveDown(path).ifPresent(ret::add);
            this.moveLeft(path).ifPresent(ret::add);
            this.moveUp(path).ifPresent(ret::add);
            return ret;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return i == position.i && j == position.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Position{");
            sb.append("i=").append(i);
            sb.append(", j=").append(j);
            sb.append('}');
            return sb.toString();
        }
    }

    private static Optional<Position> moveTo(Position t, List<Position> path) {
        boolean movable = isAvailable(t) && !path.contains(t);
        return movable ? Optional.of(t) : Optional.empty();
    }
}
