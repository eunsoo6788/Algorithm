package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution18430 {

    /**
     * 무기공학 18430
     * 백트래킹
     * not sol
     * 골드4
     */

    private static int max = 0;
    private static int ySize;
    private static int xSize;
    private static int[][] arr;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        arr = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < xSize; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);


        System.out.println(max);
    }

    private static void backtracking(int sum) {

        max = Math.max(max, sum);


        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {

                if (y-1 >= 0 && y-1 < ySize && x-1 >= 0 && x-1 < xSize
                        && !visited[y][x] && !visited[y-1][x] && !visited[y][x-1]) {
                    visited[y-1][x] = true;
                    visited[y][x] = true;
                    visited[y][x-1] = true;
                    backtracking(sum + arr[y-1][x] + arr[y][x-1] + arr[y][x]*2);
                    visited[y-1][x] = false;
                    visited[y][x] = false;
                    visited[y][x-1] = false;
                }

                if (y-1 >= 0 && y-1 < ySize && x+1 >= 0 && x+1 < xSize
                        && !visited[y][x] && !visited[y-1][x] && !visited[y][x+1]) {
                    visited[y-1][x] = true;
                    visited[y][x] = true;
                    visited[y][x+1] = true;
                    backtracking(sum + arr[y-1][x] + arr[y][x+1] + arr[y][x]*2);
                    visited[y-1][x] = false;
                    visited[y][x] = false;
                    visited[y][x+1] = false;
                }

                if (y+1 >= 0 && y+1 < ySize && x-1 >= 0 && x-1 < xSize
                        && !visited[y][x] && !visited[y+1][x] && !visited[y][x-1]) {
                    visited[y+1][x] = true;
                    visited[y][x] = true;
                    visited[y][x-1] = true;
                    backtracking(sum + arr[y+1][x] + arr[y][x-1] + arr[y][x]*2);
                    visited[y+1][x] = false;
                    visited[y][x] = false;
                    visited[y][x-1] = false;
                }

                if (y+1 >= 0 && y+1 < ySize && x+1 >= 0 && x+1 < xSize
                        && !visited[y][x] && !visited[y+1][x] && !visited[y][x+1]) {
                    visited[y+1][x] = true;
                    visited[y][x] = true;
                    visited[y][x+1] = true;
                    backtracking(sum + arr[y+1][x] + arr[y][x+1] + arr[y][x]*2);
                    visited[y+1][x] = false;
                    visited[y][x] = false;
                    visited[y][x+1] = false;
                }




            }
        }


    }





}
