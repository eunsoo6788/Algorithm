package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987 {

    /**
     * 계란으로 계란치기
     * 골드5
     */

    private static int num;
    private static int minSum;
    private static int maxSum;
    private static int abs;
    private static int count = 0;

    private static int[][] arr;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num][2];
        visited = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }









    }

    private static void solve(int depth) {




        // 기준
        for (int i = 0 ; i < num-1 ; i++) {

        }



        for (int i = depth; i < num; i++) {

            if (!visited[depth][i] && arr[i][0]>0 ) {
                visited[depth][i] = true;

                int left = arr[i][0];
                int right = arr[i][1];

                solve(depth + 1);

                arr[i][0] = left;
                arr[i][1] = right;

                visited[depth][i] = false;



            }

        }



    }


}
