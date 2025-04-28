package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1092 {

    /**
     * 배
     * 알고리즘 : 그리디
     * 골드5
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int crainNum = Integer.parseInt(br.readLine());
        int[] crains = new int[crainNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < crainNum; i++) {
            crains[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crains);

        int containerNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < containerNum; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (!pq.isEmpty()) {

            int count = 0;
            for (int i = 0; i < crainNum; i++) {

                while (!pq.isEmpty()) {

                    int now = pq.poll();

                    if (now <= crains[i]) {
                        count++;
                        while (!q.isEmpty()) {
                            pq.add(q.poll());
                        }
                        break;
                    } else {
                        q.add(now);
                    }
                }

                while (!q.isEmpty()) {
                    pq.add(q.poll());
                }

            }


            if (count == 0) {
                time = -1;
                break;
            }

            time++;

        }


        System.out.println(time);



    }

}
