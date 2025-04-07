package backjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution17390 {

    /**
     * 이건 꼭 풀어야 해!!
     * 실버3
     * 누적합
     * Sol
     */

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int caseNum = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        int[] sum = new int[num];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sum[0] = arr[0];
        for (int i = 1; i < num; i++) {
            sum[i] = arr[i];
            sum[i] += sum[i - 1];
        }



        for (int i = 0; i < caseNum; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                System.out.println(sum[b - 1]);
            } else {
                System.out.println(sum[b - 1] - sum[a - 2]);
            }


        }


    }


}
