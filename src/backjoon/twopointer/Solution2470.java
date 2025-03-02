package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2470 {

    /**
     * 두 용액 2470
     * 알고리즘 : 투 포인터
     * sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int ans = Integer.MAX_VALUE;
        int[] value = new int[2];


        int left = 0;
        int right = num - 1;


        while (left < right) {

            int abs = Math.abs(arr[left] + arr[right]);

            if (abs == 0) {
                ans = abs;
                value[0] = arr[left];
                value[1] = arr[right];
                break;
            }
            else if (abs < ans && arr[left] + arr[right] > 0) {
                ans = abs;
                value[0] = arr[left];
                value[1] = arr[right];

                right--;
            }
            else if (abs < ans && arr[left] + arr[right] < 0) {
                ans = abs;
                value[0] = arr[left];
                value[1] = arr[right];

                left++;
            }
            else if (abs >= ans && arr[left] + arr[right] > 0) {
                right--;
            }
            else if (abs >= ans && arr[left] + arr[right] < 0) {
                left++;
            }
        }

        System.out.println(value[0] + " " + value[1]);


    }
}
