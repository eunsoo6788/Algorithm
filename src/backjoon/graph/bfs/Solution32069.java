package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution32069 {

    /**
     * 가로등
     * 골드5
     * 알고리즘 : bfs
     */

    private static int[] arr;
    private static int[] light;
    private static boolean[] visited;
    private static int num;
    private static int lightNum;
    private static int answerNum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        lightNum = Integer.parseInt(st.nextToken());
        answerNum = Integer.parseInt(st.nextToken());


        light = new int[lightNum];
        arr = new int[num + 1];
        visited = new boolean[num + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lightNum; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        Arrays.sort(arr);

        for (int i = 0; i < answerNum; i++) {
            System.out.println(arr[i]);
        }

    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < lightNum; i++) {
            visited[light[i]] = true;
            queue.add(new int[]{light[i], 0});
            arr[light[i]] = 0;
        }


        while (!queue.isEmpty()) {
            int[] now = queue.poll();


            if (now[0]-1 >=0 && now[0]-1 <= num && !visited[now[0]-1]) {
                visited[now[0]-1] = true;
                queue.add(new int[]{now[0]-1, now[1]+1});
                arr[now[0]-1] = now[1]+1;
            }
            if (now[0]+1 >=0 && now[0]+1 <= num && !visited[now[0]+1]) {
                visited[now[0]+1] = true;
                queue.add(new int[]{now[0]+1, now[1]+1});
                arr[now[0]+1] = now[1]+1;
            }


        }


    }


}
