package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1522 {

    /**
     * 문자열 교환 1522
     * 실버1
     * 알고리즘 : dfs bfs
     * Not Sol
     */


    private static int num;
    private static char[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        num = str.length();
        arr = new char[num];
        visited = new boolean[num];






    }

    private static void dfs(char[] arr, int depth) {

        int count = 0;
        for (int i = 0 ; i < num ; i++) {

            if (arr[i-1] == 'b' && arr[i] == 'a' && arr[i+1] == 'b') {

            }

        }



        for (int i = 0 ; i < num ; i++) {
            if (!visited[i] && arr[i] == 'b') {
                arr[i] = 'c';
                dfs(arr,depth+1);
            }
        }


    }


}
