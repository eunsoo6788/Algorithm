package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution23843 {

    /**
     * 최소 회의실 개수 19598
     * 자료구조
     * 골드 5
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        int[] arr = new int[num];
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        Arrays.sort(arr);
        int index = arr.length -1;
        int time = 0;

        int[] queue = new int[size];

        while(true) {

            if (index >= 0){
                for (int i = 0 ; i < size ; i++) {
                    if (index >= 0 && queue[i] == 0) {
                        queue[i] = arr[index];
                        index--;
                    }
                }
            }

            boolean flag = false;
            for (int i = 0 ; i < size ; i++) {
                if (queue[i] > 0){
                    flag = true;
                    break;
                }
            }

            if (!flag){
                break;
            }

            for (int i = 0 ; i < size ; i++) {
                queue[i] -= 1;
            }

            time++;

        }


        System.out.println(time);





    }


}
