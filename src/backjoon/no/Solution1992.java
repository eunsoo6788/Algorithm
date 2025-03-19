package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1992 {

    /**
     * 쿼드트리
     * 알고리즘 : 분할정복, 재귀
     * not sol
     * 실버1
     */


    private static int num;
    private static int[][] arr;
    private static String str = "";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];

        for (int y = 0; y < num; y++) {
            String mapStr = br.readLine();
            for (int x = 0; x < num; x++) {
                arr[y][x] = mapStr.charAt(x) - '0';
            }
        }

        recur(num,0,0, ' ');

        System.out.println( str);


    }

    private static void recur(int size, int x, int y, char c) {

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

            str += '(';
            recur(size / 2, x, y, '(');
            recur(size / 2, x + size / 2, y , ' ');
            recur(size / 2, x, y + size / 2, ' ');
            recur(size / 2, x + size / 2, y + size / 2 , ')');
            str += ')';


        } else {
            str += value;
        }


    }


}
