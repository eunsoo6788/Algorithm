package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution29160 {

    /**
     * 나의 FIFA 팀 가치는? 29160
     * 자료구조 (우선순위 큐)
     * 실버 2
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            return o2[1] - o1[1];
        });


        for (int i = 0; i < size ; i++) {
            StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

            int position = Integer.parseInt(stArr.nextToken());
            int value = Integer.parseInt(stArr.nextToken());

            queue.add(new int[]{position, value});
        }


        long sum = 0;

        while (year > 0) {
            int[][] arr= new int[12][2];
            int count = 0;

            while (!queue.isEmpty() && count < 11) {

                int[] player = queue.poll();

                if (arr[player[0]][0] == 0) {
                    arr[player[0]][0] = player[0];
                    arr[player[0]][1] = player[1];
                    count++;
                } else {
                    if (arr[player[0]][1] < player[1]) {
                        arr[player[0]][1] = player[1];
                    }
                }

            }


            for (int[] playerArr: arr) {
                if (playerArr[1] > 0) {
                    playerArr[1]--;
                }
            }


            for (int[] playerArr: arr) {
                queue.add(playerArr);
            }

            year--;
        }


        int count = 0;
        int[][] arr= new int[12][2];
        while (!queue.isEmpty() && count < 11) {

            int[] player = queue.poll();

            if (arr[player[0]][0] == 0) {
                arr[player[0]][0] = player[0];
                arr[player[0]][1] = player[1];
                count++;
            } else {
                if (arr[player[0]][1] < player[1]) {
                    arr[player[0]][1] = player[1];
                }
            }

        }

        for (int[] playerArr: arr) {
            sum += playerArr[1];
        }




        System.out.println(sum);






    }


}
