
package backjoon.problemset.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14890 {

    /**
     * 경사로
     * 구현
     * 골드3
     * 문제집 : 삼성 소프트웨어 기출
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        int[][] arr = new int[num][num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0 ; i < num ; i++) {

            // 가로
            for (int j = 0 ; j < num ; j++) {

            }



            // 세로
        }




    }


}
