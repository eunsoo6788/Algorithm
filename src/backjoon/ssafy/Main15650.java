package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        int[] arr = new int[m];

        dfs(n, m, 0, visited, arr, -1);

    }


    private static void dfs(int n, int m, int depth, boolean[] visited, int[] arr, int before) {


        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < n; i++) {

            if (!visited[i] && i > before) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(n, m, depth+1, visited, arr, i);
                visited[i] = false;
            }
        }



    }


}
