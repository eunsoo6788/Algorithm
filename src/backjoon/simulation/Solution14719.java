package backjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution14719 {

    /**
     * 백준 : 빗물 14719
     * 알고리즘 : 구현
     * sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int[] arr = new int[xSize];
        // 가장 큰 기둥 크기 및 위치 구하기
        int max = 0;
        int maxIndex = 0;

        StringTokenizer xSt = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < xSize; i++) {
            arr[i] = Integer.parseInt(xSt.nextToken());

            if (max < arr[i]) {
                maxIndex = i;
                max = arr[i];
            }
        }

        int leftSum = 0;
        int leftMax = arr[0];
        // 왼쪽 넓이 구하기
        for (int i = 1; i < maxIndex; i++) {

            if (leftMax < arr[i]) {
                leftMax = arr[i];
            }

            leftSum += leftMax - arr[i];

        }

        int rightSum = 0;
        int rightMax = arr[xSize-1];
        // 오른쪽 넓이 구하기

        for (int i = xSize-2 ; i > maxIndex ; i--) {

            if (rightMax < arr[i]) {
                rightMax = arr[i];
            }

            rightSum += rightMax - arr[i];
        }


        System.out.println(leftSum + rightSum);

    }


}
