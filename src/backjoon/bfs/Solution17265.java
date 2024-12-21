package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17265 {

    /**
     * 나의 인생에는 수학과 함께 10026
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        char[][] map = new char[size][size];
        int[][] dpMin = new int[size][size];
        int[][] dpMax = new int[size][size];

        for (int y = 0; y < size; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < size; x++) {
                map[y][x] = st.nextToken().charAt(0);

                dpMax[y][x] = Integer.MIN_VALUE;
                dpMin[y][x] = Integer.MAX_VALUE;
            }
        }


        dpMax[0][0] = map[0][0] - '0';
        dpMin[0][0] = map[0][0] - '0';

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {


                if (map[y][x] >= '0' && map[y][x] <= '9') {
                    if (x + 2 < size) {
                        if (map[y][x + 1] == '+') {
                            dpMin[y][x + 2] = Math.min(dpMin[y][x + 2], dpMin[y][x] + (map[y][x + 2] - '0'));
                            dpMax[y][x + 2] = Math.max(dpMax[y][x + 2], dpMax[y][x] + (map[y][x + 2] - '0'));
                        }

                        if (map[y][x + 1] == '-') {
                            dpMin[y][x + 2] = Math.min(dpMin[y][x + 2], dpMin[y][x] - (map[y][x + 2] - '0'));
                            dpMax[y][x + 2] = Math.max(dpMax[y][x + 2], dpMax[y][x] - (map[y][x + 2] - '0'));
                        }

                        if (map[y][x + 1] == '*') {
                            dpMin[y][x + 2] = Math.min(dpMin[y][x + 2], dpMin[y][x] * (map[y][x + 2] - '0'));
                            dpMax[y][x + 2] = Math.max(dpMax[y][x + 2], dpMax[y][x] * (map[y][x + 2] - '0'));
                        }
                    }

                    if (x + 1 < size && y + 1 < size) {
                        if (map[y][x + 1] == '+') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] + (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] + (map[y + 1][x + 1] - '0'));
                        }

                        if (map[y][x + 1] == '-') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] - (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] - (map[y + 1][x + 1] - '0'));
                        }

                        if (map[y][x + 1] == '*') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] * (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] * (map[y + 1][x + 1] - '0'));
                        }


                        if (map[y+1][x] == '+') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] + (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] + (map[y + 1][x + 1] - '0'));
                        }

                        if (map[y+1][x] == '-') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] - (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] - (map[y + 1][x + 1] - '0'));
                        }

                        if (map[y+1][x] == '*') {
                            dpMin[y + 1][x + 1] = Math.min(dpMin[y + 1][x + 1], dpMin[y][x] * (map[y + 1][x + 1] - '0'));
                            dpMax[y + 1][x + 1] = Math.max(dpMax[y + 1][x + 1], dpMax[y][x] * (map[y + 1][x + 1] - '0'));
                        }
                    }

                    if (y + 2 < size) {
                        if (map[y + 1][x] == '+') {
                            dpMin[y + 2][x] = Math.min(dpMin[y + 2][x], dpMin[y][x] + (map[y + 2][x] - '0'));
                            dpMax[y + 2][x] = Math.max(dpMax[y + 2][x], dpMax[y][x] + (map[y + 2][x] - '0'));
                        }

                        if (map[y + 1][x] == '-') {
                            dpMin[y + 2][x] = Math.min(dpMin[y + 2][x], dpMin[y][x] - (map[y + 2][x] - '0'));
                            dpMax[y + 2][x] = Math.max(dpMax[y + 2][x], dpMax[y][x] - (map[y + 2][x] - '0'));
                        }

                        if (map[y + 1][x] == '*') {
                            dpMin[y + 2][x] = Math.min(dpMin[y + 2][x], dpMin[y][x] * (map[y + 2][x] - '0'));
                            dpMax[y + 2][x] = Math.max(dpMax[y + 2][x], dpMax[y][x] * (map[y + 2][x] - '0'));
                        }
                    }
                }


            }
        }


        System.out.println(dpMax[size - 1][size - 1] + " " + dpMin[size - 1][size - 1]);

    }


}
