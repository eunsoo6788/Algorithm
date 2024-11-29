package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17245 {

    /**
     * 백준 : 서버실 17245
     * 알고리즘 : 구현
     * not sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][num];

        long low = 0;
        long high = 0;
        long total = 0;

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < num; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                high = Math.max(high, arr[y][x]);
                total += arr[y][x];
            }
        }


        long target = (total + 1) / 2;

        long answer = 0;

        while (low <= high) {

            long mid = (low + high) / 2;
            long count = 0;

            for (int y = 0; y < num; y++) {
                for (int x = 0; x < num; x++) {
                    count += Math.min(arr[y][x], mid);
                }
            }


            if (count >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        System.out.println(answer);

    }


}
