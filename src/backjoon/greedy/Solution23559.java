package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution23559 {

    /**
     * 밥
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int maxA = money / 5000;

        int[][] arr = new int[num][3];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Math.abs(a - b);

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[2], Comparator.reverseOrder()));

        int sum = 0;


        for (int i = 0; i < num; i++) {

            if (arr[i][0] > arr[i][1]) {
                if (maxA > 0 && money - 5000 - (1000 * (num - i - 1)) >= 0) {
                    maxA--;
                    sum += arr[i][0];
                    money -= 5000;
                } else {
                    sum += arr[i][1];
                    money -= 1000;
                }
            } else {
                sum += arr[i][1];
                money -= 1000;

            }
        }

        System.out.println(sum);

    }


}
