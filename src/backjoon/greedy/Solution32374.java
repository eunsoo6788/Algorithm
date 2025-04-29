package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution32374 {

    /**
     * 선물 고르기
     * 알고리즘 : 그리디
     * 골드4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int boxNum = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] size = new int[num];
        for (int i = 0; i < num; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            int box = Integer.parseInt(st.nextToken());
            map.put(box, map.getOrDefault(box, 0) + 1);
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < boxNum; i++) {
            int pick = Integer.parseInt(st.nextToken());
            int pickBox = map.getOrDefault(pick, 0);

            if (pickBox == 1) {
                map.remove(pick);
            } else {
                map.put(pick, map.getOrDefault(pick, 0) - 1);
            }
        }


        int max = 0;
        for (int i : map.keySet()) {
            max = Math.max(max, i);
        }


        System.out.println(max);


    }


}
