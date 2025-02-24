package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3980 {

    private static int[][] map;
    private static boolean[] visit;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int test = 0; test < testNum; test++) {
            map = new int[11][11];
            visit = new boolean[11];
            answer = 0; // **테스트 케이스별 초기화**

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backTracking(0, 0); // **각 테스트 케이스마다 실행**
            System.out.println(answer);
        }
    }

    private static void backTracking(int sum, int depth) {
        if (depth == 11) { // **모든 포지션을 채웠다면**
            answer = Math.max(answer, sum);
            return;
        }

        for (int j = 0; j < 11; j++) { // **선수별로 포지션을 배정**
            if (!visit[j] && map[depth][j] > 0) { // **포지션이 비어있고 능력치가 0보다 크다면**
                visit[j] = true;
                backTracking(sum + map[depth][j], depth + 1);
                visit[j] = false;
            }
        }
    }
}
