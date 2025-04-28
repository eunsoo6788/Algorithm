package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21758 {

    /**
     * 꿀 따기
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        sum[0] = arr[0];


        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
        }


        int max = 0;
        for (int i = 0; i < n; i++) {

            for (int b1 = 0; b1 < 2; b1++) {


                if (b1 == 1) {
                    b1 = n -1;
                }

                if (b1 == i) {
                    continue;
                }


                for (int b2 = b1 + 1; b2 < n; b2++) {
                    if (b2 == i) {
                        continue;
                    }

                    int b1Sum = 0;
                    int b2Sum = 0;

                    if (b1 < i && b2 < i) {
                        b1Sum = Math.abs(sum[i] - sum[b1] - arr[b2]);
                        b2Sum = Math.abs(sum[i] - sum[b2]);
                    }

                    if (b1 < i && b2 > i) {
                        b1Sum = Math.abs(sum[i] - sum[b1]);
                        b2Sum = Math.abs(sum[b2 - 1] - sum[i]);
                        b2Sum += arr[i];
                    }

                    if (b1 > i && b2 > i) {
                        b1Sum = Math.abs(sum[b1 - 1] - sum[i]);
                        b2Sum = Math.abs(sum[b2 - 1] - sum[i] - arr[b1]);
                        b1Sum += arr[i];
                        b2Sum += arr[i];
                    }



                    max = Math.max(max, b1Sum + b2Sum);


                }
            }

        }

        System.out.println(max);


    }

}
