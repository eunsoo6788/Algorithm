package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution15553 {

    /**
     * 밥
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        long[] arr = new long[num];
        long time = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }



    }


}
