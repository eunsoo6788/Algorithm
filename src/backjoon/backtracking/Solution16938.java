package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16938 {
    private static int[] arr;
    private static int n, L, R, X, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        System.out.println(answer);
    }

    private static void backtrack(int start, int sum, int minVal, int maxVal, int count) {
        // 최소 2개 이상의 문제를 선택한 경우
        if (count >= 2) {
            if (sum >= L && sum <= R && (maxVal - minVal) >= X) {
                answer++;
            }
        }

        // 더 이상 탐색할 필요 없는 경우 가지치기
        if (start >= n) return;

        for (int i = start; i < n; i++) {
            backtrack(i + 1, sum + arr[i], Math.min(minVal, arr[i]), Math.max(maxVal, arr[i]), count + 1);
        }
    }
}
