package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1780 {

    /**
     * 종이의 개수
     * 알고리즘 : 분할정복, 재귀
     * not sol
     * 실버 2
     */

    private static int minus = 0;
    private static int plus = 0;
    private static int zero = 0;

    private static int num;
    private static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < num; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        recur(num,0,0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }

    private static void recur(int size, int x, int y) {

        int value = arr[y][x];
        boolean notMatch = false;
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {

                if (value != arr[i][j]) {
                    notMatch = true;
                    break;
                }

            }

            if (notMatch) {
                break;
            }
        }


        if (notMatch) {

            recur(size / 3, x, y);
            recur(size / 3, x, y + size / 3);
            recur(size / 3, x, y + (size / 3) * 2);

            recur(size / 3, x + size / 3, y);
            recur(size / 3, x + size / 3, y + (size / 3) * 2);
            recur(size / 3, x + size / 3, y + size / 3);

            recur(size / 3, x + (size / 3) * 2, y + size / 3);
            recur(size / 3, x + (size / 3) * 2, y);
            recur(size / 3, x + (size / 3) * 2, y + (size / 3) * 2);


        } else {
            if (value == 1) {
                plus++;
            } else if (value == 0) {
                zero++;
            } else if (value == -1) {
                minus++;
            }
        }


    }


}
