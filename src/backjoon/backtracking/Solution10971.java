
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10971 {

    /**
     * 외판원 순회
     * 실버2
     * 백트래킹
     */


    private static boolean[] visited;
    private static int[][] arr;
    private static int num;
    private static int max = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());


        arr = new int[num][num];
        visited = new boolean[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        backtracking(0, 0, -1, -1);

        System.out.println(max);


    }


    private static void backtracking(int depth, int sum, int start, int before) {


        if (depth == num) {

            if (arr[before][start] != 0) {
                max = Math.min(max, sum + arr[before][start]);
            }

            return;
        }

        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                if (depth == 0) {
                    start = i;
                    visited[i] = true;
                    backtracking(depth + 1, sum, i, i);
                    visited[i] = false;
                } else if (arr[before][i] != 0) {
                    visited[i] = true;
                    backtracking(depth + 1, sum + arr[before][i], start, i);
                    visited[i] = false;
                }
            }
        }

    }

}
