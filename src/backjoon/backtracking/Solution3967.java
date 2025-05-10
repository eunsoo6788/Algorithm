package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3967 {

    /**
     * 매직스타
     * 백트래킹
     * 골드5
     */

    private static char[] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[12];
        visited = new boolean[12];

        int index = 0;
        int count = 12;
        for (int i = 0 ; i < 5 ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < 9 ; j++) {
                if (str.charAt(j) != '.') {
                    arr[index] = str.charAt(j);
                    index++;

                    if (str.charAt(j) != 'x') {
                        visited[str.charAt(j)-'A'] = true;
                        count--;
                    }
                }
            }
        }


        System.out.println();

    }


    private static void solve() {


        for (int i = 0; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;

                visited[i] = false;
            }


        }


    }


}
