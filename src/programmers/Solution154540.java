package programmers;

import java.util.*;

public class Solution154540 {


    public int[] solution(String[] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    int result = bfs(maps, visited, i, j, maps[i].charAt(j) - '0');
                    list.add(result);
                }
            }
        }

        Collections.sort(list);


        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }

    private static int bfs(String[] map, boolean[][] visited, int x, int y, int depth) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;


        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length()) {
                    continue;
                }

                if (map[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    depth += map[nx].charAt(ny) - '0';
                }
            }

        }

        return depth;

    }


    public static void main(String[] args) {
        Solution154540 solution154540 = new Solution154540();
        String[] maps = new String[]{"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution154540.solution(maps)));
    }

}
