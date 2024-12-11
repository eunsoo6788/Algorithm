package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2304 {

    /**
     * 창고 다각형 2304
     * 자료구조 - 스택
     * 실버2
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        int[][] arr= new int[num][2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0] = index;
            arr[i][1] = height;
        }

        Arrays.sort(arr, (o1,o2) -> {
            return o1[1] - o2[1];
        });
        int max = arr[num-1][0];


        Arrays.sort(arr, (o1,o2) -> {
            return o1[0] - o2[0];
        });



        int maxIndex = 0;
        for (int i = 0 ; i < num ; i++) {
            if (max == arr[i][0]) {
                maxIndex = i;
                break;
            }
        }


        // 왼쪽

        int sum = 0;

        int leftHeight = arr[0][1];

        for (int i = 1; i <= maxIndex ; i++) {
            sum += leftHeight * (arr[i][0] - arr[i-1][0]);

            if (arr[i][1] > leftHeight) {
                leftHeight = arr[i][1];
            }
        }




        // 오른쪽
        int rightHeight = arr[num-1][1];

        for (int i = num - 2; i >= maxIndex ; i--) {
            sum += rightHeight * (arr[i+1][0] - arr[i][0]);

            if (arr[i][1] > rightHeight) {
                rightHeight = arr[i][1];
            }
        }


        System.out.println(sum+ rightHeight);


    }


}
