package backjoon.problemset.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution3190 {

    /**
     * 뱀
     * 구현
     * 골드 4
     * 문제집 : 삼성 소프트웨어 기출
     */

    private static class Info {
        int time;
        char direction;

        public Info (int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][num];
        int[][][] tail = new int[num][num][2];
        boolean[][] visited = new boolean[num][num];


        int appleNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < appleNum; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            arr[y][x] = 2;
        }


        Queue<Info> queue = new LinkedList<>();
        int directionNum = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < directionNum ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }


        int time = 0;
        char charDirection = 'R';
        int direction = 0;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int headX = 0;
        int headY = 0;
        int tailX = 0;
        int tailY = 0;


        visited[0][0] = true;

        while (true) {

            time++;

            int nextX = headX + dx[direction];
            int nextY = headY + dy[direction];

            // 방문한 곳이면 종료!
            if (nextX <0 || nextY < 0 || nextX >= num || nextY >= num) {
                break;
            }
            if (visited[nextY][nextX]) {
                break;
            }


            // 머리 방문 처리
            visited[nextY][nextX] = true;
            // 머리로 꼬리 이동 위치 저장
            tail[headY][headX][0] = nextX;
            tail[headY][headX][1] = nextY;


            // 사과
            if (arr[nextY][nextX] != 2) {

                // 꼬리 이동
                visited[tailY][tailX] = false;

                int[] tailInfo = tail[tailY][tailX];

                tailX = tailInfo[0];
                tailY = tailInfo[1];
            }







            // 시간이 끝난후 방향 전환
            if (!queue.isEmpty() && queue.peek().time == time) {

                Info info = queue.poll();

                if (charDirection == 'R' && info.direction == 'D' ){
                    direction = 2;
                    charDirection = 'U';
                } else if (charDirection == 'R' && info.direction == 'L' ){
                    direction = 3;
                    charDirection = 'D';
                } else if (charDirection == 'L' && info.direction == 'D' ){
                    direction = 3;
                    charDirection = 'D';
                }else if (charDirection == 'L' && info.direction == 'L' ){
                    direction = 2;
                    charDirection = 'U';
                }else if (charDirection == 'D' && info.direction == 'D' ){
                    direction = 0;
                    charDirection = 'R';
                }else if (charDirection == 'D' && info.direction == 'L' ){
                    direction = 1;
                    charDirection = 'L';
                } else if (charDirection == 'U' && info.direction == 'D' ){
                    direction = 1;
                    charDirection = 'L';
                } else if (charDirection == 'U' && info.direction == 'L' ){
                    direction = 0;
                    charDirection = 'R';
                }

            }



            headX = nextX;
            headY = nextY;








        }

        System.out.println(time);



    }


}
