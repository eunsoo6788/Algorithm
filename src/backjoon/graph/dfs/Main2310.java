
package backjoon.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2310 {

    /**
     * 어드벤쳐 게임
     * 골드4
     */

    private static int num;
    private static boolean[] visited;
    private static int[][] arr;
    private static List<Integer>[] list;
    private static boolean finished ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }

            visited = new boolean[num + 1];


            // E:0 L:1 T:2
            arr = new int[num + 1][2];
            list = new List[num + 1];

            for (int i = 1; i <= num; i++) {
                list[i] = new ArrayList<>();
            }


            for (int i = 1; i <= num; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());

                if (a == 'E') {
                    arr[i][0] = 0;
                    arr[i][1] = b;
                } else if (a == 'L') {
                    arr[i][0] = 1;
                    arr[i][1] = b;
                } else if (a == 'T') {
                    arr[i][0] = 2;
                    arr[i][1] = b;
                }


                while (true) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 0) break;

                    list[i].add(x);
                }

            }

            finished = false;
            dfs(0,0,1);

            System.out.println(finished?"Yes":"No");


        }

    }


    private static void dfs(int depth, int money, int room) {

        if (depth > num) {
            return;
        }


        for (int i = 0; i < list[room].size(); i++) {

            int nowRoom = list[room].get(i);
            if (visited[nowRoom]) continue;


            if (arr[room][0] == 0) {

                if (room == num) {
                    finished = true;

                    return;
                }

                visited[nowRoom] = true;
                dfs(depth+1, money, nowRoom);
                visited[nowRoom] = false;
            } else if (arr[room][0] == 1) {

                if (room == num) {
                    finished = true;

                    return;
                }

                visited[nowRoom] = true;
                dfs(depth+1, arr[room][1] >= money ? arr[room][1] : money , nowRoom);
                visited[nowRoom] = false;
            } else if (arr[room][0] == 2) {

                if (money < arr[room][1]) {
                    continue;
                }


                if (room == num) {
                    finished = true;

                    return;
                }


                visited[nowRoom] = true;
                dfs(depth+1, money - arr[room][1] , nowRoom);
                visited[nowRoom] = false;
            }



        }


    }


}
