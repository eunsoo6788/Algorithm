package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3980 {
    private static int[][] map;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testcases; t++) {

            map = new int[11][11];
            visited = new boolean[11];

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backtrack(0, 0);

            System.out.println(answer);

        }
    }


    private static void backtrack(int sum, int depth) {

        if (depth == 11) {
            answer = Math.max(answer, sum);
        }


        for (int i = 0; i < 11; i++) {

            if (!visited[i]) {
               visited[i] = true;
               backtrack(sum+map[depth][i], depth + 1);
               visited[i] = false;
            }
        }

    }


}
