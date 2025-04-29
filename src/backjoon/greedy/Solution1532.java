package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1532 {

    /**
     * 동전교환
     * 알고리즘 : 그리디
     * 골드4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int g2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());


        // 금이 충분한 경우
        if (g1 > g2) {

            // 은이 충분한 경우
            if (s1 > s2) {

                // 동이 충분한 경우
                if (d1 > d2) {
                    System.out.println(0);
                    return;
                } else {

                }


            }


        }




    }


}
