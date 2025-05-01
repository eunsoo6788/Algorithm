package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main13164 {

    /**
     * 행복 유치원
     * 골드5
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        int[] ans = new int[num-1];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i >= 1) {
                ans[i-1] =  Math.abs(arr[i] - arr[i-1]);
            }
        }

        Arrays.sort(ans);

        long sum = 0;

        for (int i = 0; i < num - size; i++) {
            sum += ans[i];
        }

        System.out.println(sum);





    }


}
