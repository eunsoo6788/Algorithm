package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution16918 {

    /**
     * 백준 : 봄버맨 16918
     * 알고리즘 : 구현
     * sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        char[][] arr = new char[ySize][xSize];

        if (second % 2 == 0) {
            for (int i = 0; i < ySize; i++) {
                Arrays.fill(arr[i],'O');
                for (int j = 0; j < xSize; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            return;
        }

        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                arr[y][x] = str.charAt(x);
            }
        }


        char[] bomb = new char[] {'O','.'} ;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        int count = (second+1)/2 -1 ;
        int now = 0;
        while (now < count) {
            char nowBomb = bomb[now%2];


            List<int[]> list = new ArrayList<>();
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {
                    if (arr[y][x] == nowBomb) {
                        list.add(new int[]{y,x});

                    }
                }
            }

            for (int[] point : list) {
                for (int k = 0; k < 4; k++) {
                    int nx = point[1] + dx[k];
                    int ny = point[0] + dy[k];
                    if (nx >= 0 && ny < ySize && ny >= 0 && nx < xSize) {
                        arr[ny][nx] = nowBomb;
                    }
                }
            }

            now++;
        }


        if (now % 2 == 1) {
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {
                    if (arr[y][x] == '.') {
                        arr[y][x] = 'O';
                    } else {
                        arr[y][x] = '.';
                    }

                    System.out.print(arr[y][x]);

                }
                System.out.println();
            }
        }
        else {
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {
                    System.out.print(arr[y][x]);
                }
                System.out.println();
            }
        }



    }


}
