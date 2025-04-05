package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2696 {

    /**
     * 중앙값 구하기
     * 우선순위 큐
     * 골드2
     * not sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int test = 0; test < n; test++) {

            int number = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            System.out.println((number+1)/2);

            for (int i = 0; i < number; i++) {

                if (i/10 > 0 && i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                pq.add(Integer.parseInt(st.nextToken()));


                int count = 0 ;
                if (i % 2 == 0) {

                    int nowSize = pq.size() +1;
                    int middle = (nowSize / 2) -1;

                    PriorityQueue<Integer> tmp = new PriorityQueue<>();

                    int value = 0;
                    for (int k = 0; k <= middle; k++) {

                        value = pq.poll();
                        tmp.add(value);
                    }

                    System.out.print(value + " ");
                    count++;

                    for (int k = 0; k <= middle; k++) {
                        pq.add(tmp.poll());
                    }

                    if (count > 0 && count % 10==0) {
                        System.out.println();
                    }
                }


            }


            System.out.println();


        }

    }


}
