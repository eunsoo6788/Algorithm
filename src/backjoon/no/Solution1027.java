package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1027 {

    /**
     * 백준 : 고층건물 1027
     * 알고리즘 : 구현
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int max = 0;

        for (int index = 0; index < num; index++) {
            int highIndex = index;
            int high = arr[highIndex] ;
            int count = 0;

            // 왼쪽 탐색
            double leftLean = Double.MAX_VALUE;
            for (int i = highIndex-1; i >= 0; i--) {

                double lean = (double)(arr[highIndex]-arr[i])/(highIndex - i);

                if (lean < leftLean) {
                    count++;
                    leftLean = lean;
                }

            }

            double rightLean = Double.MAX_VALUE;
            for (int i = highIndex+1; i < num; i++) {
                double lean = (double)(arr[highIndex]-arr[i])/(i - highIndex);
                if (lean < rightLean) {
                    count++;
                    rightLean = lean;
                }
            }


            max = Math.max(max, count);






        }


        System.out.println(max);

    }




}
