package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution11497 {

    /**
     * 백준 : 통나무 건너뛰기
     * 알고리즘 : 그리디
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testNum; testCase++) {

            int num = Integer.parseInt(br.readLine());

            int[] arr = new int[num];
            int[] answer = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(arr);

            int left = 0 ;
            int right = num -1 ;

            for (int i = 0 ; i < num ; i++) {

                if (i % 2 == 0) {
                    answer[left++] = arr[i];
                } else {
                    answer[right--] = arr[i];
                }

            }

            int distance = 0;
            for (int i = 0 ; i < num ; i++ ) {
                if (i == num -1) {
                    distance = Math.max(distance, Math.abs(answer[i] - answer[0]));
                } else {
                    distance = Math.max(distance, Math.abs(answer[i] - answer[i+1]));
                }
            }


            System.out.println(distance);



        }


    }
}
