package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15645 {

    private static int num;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        int[][] maxDp = new int[num][num];
        int[][] minDp = new int[num][num];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < num; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());

                if (y == 0) {
                    maxDp[y][x] = arr[y][x];
                    minDp[y][x] = arr[y][x];
                } else{
                    minDp[y][x] = Integer.MAX_VALUE;
                }
            }
        }



        for (int y = 0; y < num-1; y++) {
            for (int x = 0; x < num; x++) {

                if (x == 0) {
                    maxDp[y+1][x] = Math.max(maxDp[y+1][x], maxDp[y][x] + arr[y+1][x]);
                    maxDp[y+1][x+1] = Math.max(maxDp[y+1][x+1], maxDp[y][x] + arr[y+1][x+1]);

                    minDp[y+1][x] = Math.min(minDp[y+1][x], minDp[y][x] + arr[y+1][x]);
                    minDp[y+1][x+1] = Math.min(minDp[y+1][x+1], minDp[y][x] + arr[y+1][x+1]);
                } else if (x == num -1) {
                    maxDp[y+1][x] = Math.max(maxDp[y+1][x], maxDp[y][x] + arr[y+1][x]);
                    maxDp[y+1][x-1] = Math.max(maxDp[y+1][x-1], maxDp[y][x] + arr[y+1][x-1]);

                    minDp[y+1][x] = Math.min(minDp[y+1][x], minDp[y][x] + arr[y+1][x]);
                    minDp[y+1][x-1] = Math.min(minDp[y+1][x-1], minDp[y][x] + arr[y+1][x-1]);
                } else {
                    maxDp[y+1][x+1] = Math.max(maxDp[y+1][x+1], maxDp[y][x] + arr[y+1][x+1]);
                    maxDp[y+1][x] = Math.max(maxDp[y+1][x], maxDp[y][x] + arr[y+1][x]);
                    maxDp[y+1][x-1] = Math.max(maxDp[y+1][x-1], maxDp[y][x] + arr[y+1][x-1]);

                    minDp[y+1][x] = Math.min(minDp[y+1][x], minDp[y][x] + arr[y+1][x]);
                    minDp[y+1][x-1] = Math.min(minDp[y+1][x-1], minDp[y][x] + arr[y+1][x-1]);
                    minDp[y+1][x+1] = Math.min(minDp[y+1][x+1], minDp[y][x] + arr[y+1][x+1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i= 0 ; i < num ; i++){
            max = Math.max(maxDp[num-1][i], max);
            min = Math.min(minDp[num-1][i], min);
        }


        System.out.println(max + " " + min);



    }



}
