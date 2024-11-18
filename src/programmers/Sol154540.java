package programmers;

import java.util.Arrays;

public class Sol154540 {

    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static String[][] map;



    public int[] solution(String[] maps) {
        int[] answer = {};

        visited = new boolean[maps.length][maps[0].length()];
        map = new String[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j) + "";
            }
        }



        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = dfs(j, i, 0);
                    System.out.println(sum);
                }
            }
        }



        return answer;
    }


    private int dfs(int x, int y, int sum) {

        visited[y][x] = true;
        sum += Integer.parseInt(map[y][x]);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= visited[0].length || nextY >= visited.length) {
                continue;
            }

            if (visited[nextY][nextX] || map[nextY][nextX].equals("X")) {
                continue;
            }

            dfs(nextX, nextY, sum);
        }


        return sum;
    }


    public static void main(String[] args) {
        Sol154540 sol = new Sol154540();
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(sol.solution(maps)));
    }
}
