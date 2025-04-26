package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution29160Re {

    /**
     * 나의 FIFA 팀 가치는?
     * <p>
     * 브론즈4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int position = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            arr[i][0] = position;
            arr[i][1] = price;
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < num; i++) {
            pq.add(new int[]{arr[i][0], arr[i][1]});
        }


        boolean[] visited;
        for (int i = 0; i < year; i++) {

            visited = new boolean[num];

            for (int j = 0; j < num; j++) {
                int[] now = pq.poll();

                if (!visited[now[0]]) {
                    visited[now[0]] = true;
                    pq.add(new int[]{now[0], now[1]});
                }
                

            }


        }

    }


}
