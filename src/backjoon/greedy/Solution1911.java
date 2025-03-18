package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1911 {


    /**
     * 1911
     * 골드5
     * 알고리즘 : 그리디
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int panLen = Integer.parseInt(st.nextToken());
        int[][] map = new int[num][2];


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(map, Comparator.comparingInt(o->o[0]));


        // 정렬된 웅덩이를 널빤지로 순서대로 덮는다. 앞에서 부터 덮을 예정

        int now = 0;
        int count = 0;


        for (int i = 0; i < num; i++) {

            int start = map[i][0];
            int end = map[i][1];

            if (now >= end-1) {
                continue;
            }

            if (now >= start) {
                start = now + 1;
            } else {
                start = map[i][0];
            }

            int length = end - start;
            int needCount = 0;
            if (length % panLen == 0) {
                needCount += length / panLen;

            } else {
                needCount += length / panLen + 1;
            }

            now = (start + panLen * needCount - 1);
            count += needCount;


        }


        System.out.println(count);


    }
}
