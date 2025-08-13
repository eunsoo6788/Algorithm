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
     * 골드 3
     */

    private static int xSize;
    private static int ySize;
    private static int tramSize;
    private static int startNum;
    private static int[][] map;
    private static int[][] tmp;
    private static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        xSize = Integer.parseInt(st.nextToken()) + 1;
        ySize = Integer.parseInt(st.nextToken()) + 1;
        tramSize = Integer.parseInt(st.nextToken())+1;
        startNum = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        tmp = new int[ySize - tramSize][xSize - tramSize];
        for (int i = 0; i < startNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x]++;
        }


        for (int y = 0; y < ySize - tramSize; y++) {
            int count = 0;
            for (int x = 0; x < xSize - tramSize; x++) {



                if (x == 0) {
                    count = count(x, y);
                } else {
                    count += colCount(x, y);
                    count -= tmp[y][x - 1];
                }

                max = Math.max(max, count);

            }
        }


        System.out.println(startNum-max);


    }

    private static int colCount(int x, int y) {

        int count = 0;
        for (int i = 0; i < tramSize; i++) {
            if (map[y + i][x + tramSize] == 1) {
                count++;
            }
        }


        return count;
    }

    private static int count(int startX, int startY) {

        int count = 0;
        for (int x = startX; x < startX + tramSize; x++) {
            for (int y = startY; y < startY + tramSize; y++) {
                if (map[y][x] == 1) {
                    count++;
                    tmp[startY][x]++;
                }
            }
        }

        return count;
    }


}
