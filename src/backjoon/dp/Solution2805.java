package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());


        int[] arr = new int[num];

        long low = 1;
        long high = Integer.MAX_VALUE;

        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.min(high, arr[i]);
        }


        while (low <= high) {

            long mid = (low + high) / 2;
            long sum = 0;


            for (int i = 0 ; i < num ; i++) {
                sum += arr[i]/mid;
            }


            if (sum >= target) {
                low = mid + 1;
            } else {
                high = mid - 1 ;
            }

        }

        System.out.println(high);




    }


}
