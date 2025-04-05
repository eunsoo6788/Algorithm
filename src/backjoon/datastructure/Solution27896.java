package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution27896 {

    /**
     * 나는 기말고사형 인간이야
     * 우선순위 큐
     * 골드 5
     * not sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int total = 0;
        int count = 0;



        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            total += arr[i];
            pq.add(arr[i]);

            while (total >= limit) {
                count++;
                total -= (pq.poll()*2);

            }
        }


        System.out.println(count);









    }


}
