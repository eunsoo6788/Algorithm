package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution16920 {

    /**
     * 확장 게임
     * 골드2
     */

    private static int num;
    private static int xSize;
    private static int ySize;

    private static int[] arr;
    private static int[] answer;

    private static int count = 0;
    private static char[][] map;
    private static boolean finish = false;
    private static boolean[][] visited;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        arr = new int[num+1];
        answer = new int[num+1];
        graph = new List[num+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= num; i++) {
            arr[i-1] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();

        }

        map = new char[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x);

                if (map[y][x] >= '0' && map[y][x] <= '9') {
                    graph[map[y][x]-'0'].add(new Node(x, y));
                    answer[map[y][x]-'0']++;
                }

            }
        }


        visited = new boolean[ySize][xSize];
        while (true) {
            finish = false;

            for (int i = 1; i <= num; i++) {
                bfs(i);
            }

            if (!finish) {
                break;
            }
        }

        for (int i = 1; i <= num; i++) {
            System.out.print(answer[i] + " ");
        }


    }


    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static void bfs(int player) {
        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.depth));

        for (Node node : graph[player]) {
            queue.add(new Point(node.x, node.y, 0));
            visited[node.y][node.x] = true;
        }

        graph[player].clear();



        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.depth >= arr[player-1]) {
                break;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= xSize || ny < 0 || ny >= ySize) {
                    continue;
                }

                if (!visited[ny][nx] && now.depth < arr[player-1]) {
                    if (map[ny][nx] == '.') {
                        count++;
                        finish = true;
                        answer[player]++;
                        map[ny][nx] = (char) (player+'0') ;
                        graph[player].add(new Node(nx, ny));
                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny, now.depth + 1));
                    }
                }
            }
        }


    }


    private static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
