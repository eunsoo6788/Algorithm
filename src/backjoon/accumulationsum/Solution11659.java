package backjoon.accumulationsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11659 {


    /**
     * 구간 합 구하기5 11660
     * 알고리즘 : 구간합
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int testNum = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][num];
        int[][] sum = new int[num][num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (j == 0 ) {
                    sum[i][j] = arr[i][j];
                } else {
                    sum[i][j] = sum[i][j - 1] + arr[i][j];
                }
            }
        }

        for (int i = 1; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int answer = sum[x2][y2];

            if (x1 > 0) {
                answer -= sum[x1-1][y2];
            }

            if (y1 > 0) {
                answer -= sum[x2][y1-1];
            }

            if (x1 > 0 && y1 > 0) {
                answer += sum[x1-1][y1-1];
            }


            System.out.println(answer);


        }

    }
}
