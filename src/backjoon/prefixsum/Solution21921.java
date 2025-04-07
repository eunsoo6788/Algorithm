package backjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21921 {

    /**
     * 블로그
     * 실버3
     * 누적합
     * Not Sol
     */

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i - 1];
        }


        int max = arr[target - 1];
        int count = 1;

        for (int i = target; i < num; i++) {

            if (max < arr[i] - arr[i - target]) {
                max = arr[i] - arr[i - target];
                count = 1;
            } else if (max == arr[i] - arr[i - target]) {
                count++;
            }
        }


        if (max == 0 ) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);




    }


}
