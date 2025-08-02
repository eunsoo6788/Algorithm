package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2118 {

    /**
     * 두개의탑
     * 투 포인터
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int total = 0;
        int[] arr = new int[num];
        int[] sum = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
            if (i >= 1) {
                sum[i] = sum[i - 1] + arr[i];
            }
        }

        Arrays.sort(arr);

        int mid = total / 2;
        int low = 0;
        int high = 0;
        int max = 0;

        while (high < num) {

            int dis = sum[high] - sum[low];

            if (dis > mid) {
                dis = Math.min(dis, total - dis);
                max = Math.max(max, dis);
                low++;
            } else if (dis == mid) {
                max = dis;
                break;
            }else {
                dis = Math.min(dis, total - dis);
                max = Math.max(max, dis);
                high++;
            }

        }

        System.out.println(max);


    }
}
