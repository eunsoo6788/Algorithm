package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution159993 {

    public int solution(String[] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                if (!visited[i][j] && maps[i].charAt(j) == 'S') {

                    visited[i][j] = true;
                    answer += bfs('L', i, j, visited, maps);
                }

            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                if (visited[i][j] && maps[i].charAt(j) == 'L') {
                    answer += bfs('E', i, j, visited, maps);
                }

            }
        }


        return answer ==0 ? -1 : answer;
    }

    private static int bfs(char target, int y, int x, boolean[][] visited, String[] maps) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, 0});
        int answer = 0;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            if (maps[poll[1]].charAt(poll[0]) == target) {
                answer = poll[2];
                break;
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];

                if (nx >= 0 && ny >=0 && nx < maps.length && ny < maps[0].length()
                        && !visited[ny][nx] && maps[ny].charAt(nx) != 'X') {

                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, poll[2]+1});
                }
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        Solution159993 solution159993 = new Solution159993();
        System.out.println(solution159993.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }

}
