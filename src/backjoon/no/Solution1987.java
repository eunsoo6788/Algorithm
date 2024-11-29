package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1987 {

    /**
     * 백준 : 알파벳
     * 알고리즘 : dfs bfs
     * not sol
     * 골드 4
     */

    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> queue;

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        map = new char[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            map[y] = br.readLine().toCharArray();
        }

        queue = new LinkedList<>();

        bfs(0,0);

        System.out.println(count);


    }


    private static void bfs(int x, int y) {
        Set<Character> use = new HashSet<>();


        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        queue.add(new int[]{x, y, 1});
        use.add(map[y][x]);

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            count = Math.max(count, poll[2]);

            for (int i = 0 ; i  <4 ; i++) {

                int nx = poll[0] +dx[i];
                int ny = poll[1] +dy[i];

                if (nx >= 0 && ny>= 0 && nx < map[0].length && ny < map.length) {

                    if (!use.contains(map[ny][nx])) {
                        use.add(map[ny][nx]);
                        queue.add(new int[]{nx, ny, poll[2] + 1});
                    }
                }

            }

        }


    }


}
