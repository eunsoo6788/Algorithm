package backjoon.accumulationsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution19951 {

    /**
     * 태상이의 훈련소 생활 19951
     * 알고리즘 : 구간합
     * not sol
     * 골드 5
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 연병장의 크기
        int M = Integer.parseInt(st.nextToken()); // 조교의 수

        int[] height = new int[N + 1]; // 연병장 초기 높이 배열
        int[] diff = new int[N + 2]; // 차분 배열 (N+1까지 필요)

        // 초기 연병장 높이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 조교의 지시 반영 (차분 배열 이용)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            diff[a] += k;   // a 위치부터 k 증가
            diff[b + 1] -= k; // b+1 위치부터 k 감소
        }

        // 차분 배열을 이용하여 실제 값 적용
        int change = 0;
        for (int i = 1; i <= N; i++) {
            change += diff[i];  // 누적합을 계산
            height[i] += change; // 원래 배열에 반영
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(height[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
