package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution25391 {

    /**
     * 특별상
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int reader = Integer.parseInt(st.nextToken());
        int simpan = Integer.parseInt(st.nextToken());


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o2[1] - o1[1]);

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{a, b});
        }

        long sum = 0;
        for (int i = 0; i < simpan; i++) {
            sum += pq.poll()[0];
        }

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1,o2) -> o2[0] - o1[0]);

        while (!pq.isEmpty()) {
            pq1.offer(pq.poll());
        }

        for (int i = 0; i < reader; i++) {
            sum += pq1.poll()[0];
        }

        System.out.println(sum);


    }


}
