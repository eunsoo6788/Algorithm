package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14658 {

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

        int[][] map = new int[ySize][xSize];


        for (int i = 0; i < starNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        int max = 0;
        int count = 0;

        for (int y = 0; y < ySize- tramSize; y++) {
            for (int x = 0; x < xSize - tramSize; x++) {

                if (x == 0) {
                    for (int i = 0; i < tramSize; i++) {
                        for (int j = 0; j < tramSize; j++) {

                            if (map[i][j] == 1) {
                                count++;
                            }

                        }
                    }

                }  else {
                    for (int i = 0; i < tramSize; i++) {
                        if (map[y+i][x-1] == 1) {
                            count--;
                        }

                        if (map[y+i][x+tramSize] == 1) {
                            count++;
                        }
                    }
                }


                max = Math.max(max, count);
            }
        }


        System.out.println(starNum-max);






    }



}
