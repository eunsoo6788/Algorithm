package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3980 {

    /**
     * 선발명단
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int answer;
    private static int[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int test = Integer.parseInt(br.readLine());

        for (int problem = 0; problem < test; problem++) {

            answer = 0;
            arr = new int[11][11];
            visited = new boolean[11];

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }


            solve(0,0);

            System.out.println(answer);

        }
    }


    private static void solve(int depth, int sum) {


        if (depth == 11) {
            answer = Math.max(answer, sum);
            return;
        }



        for (int i = 0; i < 11; i++) {

            if (!visited[i] && arr[depth][i] > 0) {

                visited[i] = true;
                solve(depth + 1, sum + arr[depth][i]);
                visited[i] = false;
            }


        }



    }

}
