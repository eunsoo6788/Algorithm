package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3967 {

    /**
     * 매직스타
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int xSize = 9;
    private static int ySize = 5;
    private static int size;
    private static char[][] arr;
    private static char[] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        arr = new char[ySize][xSize];
        size = 'L'-'A' +1;
        visited = new boolean[size];
        map = new char[size];



        for (int i = 0 ; i < ySize ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < xSize ; j++) {
                char c = str.charAt(j);

                if (c != '.' && c!= 'x') {
                    visited[c-'A'] = true;
                }

                arr[i][j] = c;

            }
        }


        System.out.println(arr);

    }


    private static void backTracking(String str) {



        for (int i =0 ; i < size ; i++) {

        }


    }


}
