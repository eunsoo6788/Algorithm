package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution18428 {

    private static int num;
    private static char[][] arr;
    private static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new char[num][num];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < num; x++) {
                arr[y][x] = st.nextToken().charAt(0);
            }

        }

        bfs(0);

        if (finish) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static void bfs(int depth) {

        if (finish) {
            return;
        }

        if (depth == 3) {
            boolean value = check();

            if (value) {
                finish = true;
            }
            return;
        }


        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {
                if (arr[y][x] == 'X') {
                    arr[y][x] = 'O';
                    bfs(depth + 1);
                    arr[y][x] = 'X';
                }
            }
        }

    }

    private static boolean check() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};


        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {
                if (arr[y][x] == 'T') {

                    for (int i = 0; i < 4; i++) {

                        int nx = x;
                        int ny = y;

                        while (true) {

                            nx += dx[i];
                            ny += dy[i];

                            if (nx < 0 || ny < 0 || nx >= num || ny >= num) {
                                break;
                            }

                            if (arr[ny][nx] == 'O') {
                                break;
                            }

                            if (arr[ny][nx] == 'S') {
                                return false;
                            }



                        }

                    }


                }
            }
        }

        return true;
    }

}
