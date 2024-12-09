package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution19598 {

    /**
     * 최소 회의실 개수 19598
     * 자료구조
     * 골드 5
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int max = 0;
        int[][] arr = new int[num][2];
        for (int i = 0 ; i < num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr, (o1,o2) ->  {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });


        Queue<Integer> endTimeQueue = new PriorityQueue<>();

        for (int i = 0 ; i < num ; i++ ) {

            // 강의 끝났는지 확인
            while (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= arr[i][0]) {
                endTimeQueue.poll();
            }

            endTimeQueue.add(arr[i][1]);

            max = Math.max(max, endTimeQueue.size());

        }

        System.out.println(max);



    }


}
