package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution14658Re {

    /**
     * 백준 : 하늘에서 별똥별이 빗발친다 14658
     * 알고리즘 : no?
     * not sol
     * 골드 3
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int xSize = Integer.parseInt(st.nextToken())+1;
        int ySize = Integer.parseInt(st.nextToken())+1;
        int tramSize = Integer.parseInt(st.nextToken());
        int starNum = Integer.parseInt(st.nextToken());

        int[][] map = new int[starNum][2];


        for (int i = 0; i < starNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[i][0] = x;
            map[i][1] = y;
        }

        Arrays.sort(map, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });


        int max = 0;
        for (int i = 0; i < starNum; i++) {
            int count = 1;

            for (int j = i+1; j < starNum; j++) {

                if (map[i][0] + tramSize -1 >= map[j][0]  && map[i][1] + tramSize -1 >= map[j][1]) {
                    count++;
                } else if (map[i][0] + tramSize-1 < map[j][0]  && map[i][1] + tramSize -1 < map[j][1]) {
                    break;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(starNum-max);






    }



}
