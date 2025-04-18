package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14889 {

    /**
     * 스타트와 링크
     * 실버1
     * 백트래킹
     */

    private static int[][] map;
    private static int size;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];



        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < size; i++) {
            boolean[] visited = new boolean[size];
            int[] arr = new int[size/2];

            visited[i] = true;
            arr[0] = i + 1;
            dfs(1, visited, arr);
        }

    }

    private static void dfs(int depth, boolean[] visited, int[] arr) {

        if (depth+1 == size/2) {

            for (int i = 0; i < size/2; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;


        }

        for (int i = 0; i < size; i++) {

            if (!visited[i] ) {

                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, visited, arr);
                visited[i] = false;
            }
        }
    }





}
