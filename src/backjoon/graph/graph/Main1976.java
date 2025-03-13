package backjoon.graph.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1976 {



    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine());
        int tripCityNum = Integer.parseInt(br.readLine());


        List<Integer>[] list = new List[cityNum + 1];
        list[0] = new ArrayList<>();
        for (int i = 1; i <= cityNum; i++) {
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= cityNum; j++) {
                int visited = Integer.parseInt(st.nextToken());
                if (visited == 1) {
                    list[i].add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[tripCityNum];
        for (int i = 0; i < tripCityNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean answer = true;

        for (int i = 1; i < tripCityNum; i++) {

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[cityNum+1];

            int start = arr[i-1];
            int end = arr[i];

            queue.add(start);

            boolean flag = false;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                if (now == end) {
                    flag = true;
                    break;
                }

                if (visited[now]) {
                    continue;
                }

                visited[now] = true;
                for (int next : list[now]) {
                    if (!visited[next]) {
                        queue.add(next);
                    }
                }



            }

            if (!flag) {
                answer = false;
                break;
            }


        }

        if (answer) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }









    }







}
