package backjoon.no;
import java.io.*;
import java.util.*;

public class Solution9881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] hills = new int[N];
        for (int i = 0; i < N; i++) {
            hills[i] = Integer.parseInt(br.readLine());
        }

        int minCost = Integer.MAX_VALUE;

        // 가능한 모든 범위를 탐색 (높이 0~100이므로 83까지만 해도 충분)
        for (int low = 0; low <= 83; low++) {
            int high = low + 17;
            int cost = 0;

            for (int h : hills) {
                if (h < low) {
                    cost += (low - h) * (low - h);
                } else if (h > high) {
                    cost += (h - high) * (h - high);
                }
            }

            minCost = Math.min(minCost, cost);
        }

        System.out.println(minCost);
    }
}
