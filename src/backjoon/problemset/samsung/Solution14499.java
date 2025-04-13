package backjoon.problemset.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14499 {

    /**
     * 주사위 굴리기
     * 구현
     * 골드 4
     * 문제집 : 삼성 소프트웨어 기출
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int nowY = Integer.parseInt(st.nextToken());
        int nowX = Integer.parseInt(st.nextToken());

        int num = Integer.parseInt(st.nextToken());


        int[][] arr = new int[ySize][xSize];


        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        int[] dx = {0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, -1, 1};

        int[] nand = {0,0,0,0,0,0}; //바닥 앞 위 뒤 //왼쪽 오른쪽


        nand[0] = arr[nowY][nowX];
        arr[nowY][nowX] = 0;


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {

            int direction = Integer.parseInt(st.nextToken());

            int nx = nowX + dx[direction];
            int ny = nowY + dy[direction];

            if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                continue;
            }


            if (direction == 1 ) {
                int[] tmp = {nand[0],nand[1],nand[2],nand[3],nand[4],nand[5]};

                nand[0] = tmp[5];
                nand[1] = tmp[1];
                nand[2] = tmp[4];
                nand[3] = tmp[3];
                nand[4] = tmp[0];
                nand[5] = tmp[2];
            }

            if (direction == 2 ) {
                int[] tmp = {nand[0],nand[1],nand[2],nand[3],nand[4],nand[5]};

                nand[0] = tmp[4];
                nand[1] = tmp[1];
                nand[2] = tmp[5];
                nand[3] = tmp[3];
                nand[4] = tmp[2];
                nand[5] = tmp[0];
            }


            if (direction == 4 ) {
                int[] tmp = {nand[0],nand[1],nand[2],nand[3],nand[4],nand[5]};

                nand[0] = tmp[3];
                nand[1] = tmp[0];
                nand[2] = tmp[1];
                nand[3] = tmp[2];
                nand[4] = tmp[4];
                nand[5] = tmp[5];
            }

            if (direction == 3 ) {
                int[] tmp = {nand[0],nand[1],nand[2],nand[3],nand[4],nand[5]};

                nand[0] = tmp[1];
                nand[1] = tmp[2];
                nand[2] = tmp[3];
                nand[3] = tmp[0];
                nand[4] = tmp[4];
                nand[5] = tmp[5];
            }


            if (arr[ny][nx] == 0 ) {
                arr[ny][nx] = nand[0];
            } else {
                nand[0] = arr[ny][nx];
                arr[ny][nx] = 0;
            }


            nowX = nx;
            nowY = ny;

            System.out.println(nand[2]);


        }

    }


}
