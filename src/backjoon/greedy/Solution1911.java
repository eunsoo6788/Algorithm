package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1911 {

    /**
     * 백준 : 흙길 보수하기 1911
     * 알고리즘 : 그리디
     * not sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }


        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int index = -1;
        int count = 0;

        for (int i = 0; i < num; i++) {

            if (index < arr[i][0]) {
                index = arr[i][0];
            } else {
                index++;
            }

            int length = arr[i][1] - index;

            if (length % size == 0) {
                count += length / size;
                index += (length / size) * size - 1;
            } else {
                count += length / size +1;
                index += (length / size + 1) * size - 1;
            }

        }

        System.out.println(count);


    }

}
