package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15686 {

    /**
     * 백준 : 치킨배탈 15686
     * 백트래킹
     * sol
     * 골드 5
     */

    private static int size;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        size = Integer.parseInt(st.nextToken());
        int chickenNum = Integer.parseInt(st.nextToken());


        int[][] arr= new int[size][size];
        boolean[][] visited = new boolean[size][size];


        List<int[]> list = new ArrayList<>();

        for (int y = 0 ; y < size ; y++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int x = 0 ; x < size ; x++) {
                arr[y][x] = Integer.parseInt(st1.nextToken());

                if (arr[y][x] == 2) {
                    list.add(new int[]{x,y});
                }
            }
        }


        boolean[] chickenVisited = new boolean[list.size()];




    }


    private static void bfs(int x, int y) {







    }


    private static void backTracking(List<int[]> list, boolean[] visited, int[][] chickenArr, int depth, int chickenNum) {

        if (depth == chickenNum) {

            for (int y = 0; y < size ; y++) {
                for (int x = 0 ; x< size; x++) {



                }
            }


        }


        for (int i = 0 ; i < list.size() ; i++) {

            if (!visited[i]) {
                visited[i] = true;
                chickenArr[depth][0] = list.get(i)[0];
                chickenArr[depth][1] = list.get(i)[1];
                backTracking(list,visited,chickenArr,depth+1, 0);

                visited[i] = false;


            }

        }






    }


}
