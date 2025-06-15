package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4781 {

    /**
     * 사탕가게
     * 골드4
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num = Integer.parseInt(st.nextToken());
        double bag = Double.parseDouble(st.nextToken());

        int[] valueArr = new int[num];
        double[] weightArr = new double[num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            valueArr[i] = Integer.parseInt(st.nextToken());
            weightArr[i] = Double.parseDouble(st.nextToken());
        }





    }


}
