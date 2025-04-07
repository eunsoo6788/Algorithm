package backjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12847 {

    /**
     * 꿀 아르바잍트
     * 실버3
     * 누적합
     * Sol
     */

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (target == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        long[] arr = new long[num];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i - 1];
        }

        long max = arr[target - 1];

        for (int i = target; i < num; i++) {
            max = Math.max(max, arr[i]- arr[i-target]);
        }

        System.out.println(max);

    }


}
