package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3649 {

    /**
     * 로봇 프로젝트
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        while ((s = br.readLine()) != null) {

            int limit = Integer.parseInt(s) * 10000000;
            int num = Integer.parseInt(br.readLine());

            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int low = 0;
            int high = arr.length - 1;
            boolean flag = false;
            while (low < high) {

                int sum = arr[low] + arr[high];

                if (sum > limit) {
                    high--;
                } else if (sum < limit) {
                    low++;
                } else {
                    flag = true;
                    break;
                }


            }

            if (flag) {
                System.out.println("yes" + " " + arr[low] + " " + arr[high]);
            } else {
                System.out.println("danger");
            }

        }




    }
}
