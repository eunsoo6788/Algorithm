package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {

    public int solution(int[][] maps) {
        int answer = 0;



        dfs(maps, 0, 0, 1);


        return answer;
    }

    private void dfs(int[][] maps, int y, int x, int num) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<int[][]> queue = new LinkedList<>();

        queue.add(new int[][]{{y, x}});
        visited[y][x] = true;


        while (!queue.isEmpty()) {
            int[][] poll = queue.poll();
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = poll[0][0] + dx[i];
                int ny = poll[0][1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }

                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[][]{{nx, ny}});
                    visited[nx][ny] = true;
                    num++;
                }
            }

        }




    }




    public static void main(String[] args) {
        Solution1844 solution1844 = new Solution1844();
        System.out.println(solution1844.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }


}
