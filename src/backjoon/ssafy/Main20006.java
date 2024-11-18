package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20006 {

    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int roomTotal = Integer.parseInt(st.nextToken());

        String[][] player = new String[size][2];

        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            player[i][0] = String.valueOf(level);
            player[i][1] = nickname;

        }

        boolean[] visited = new boolean[size];

        int count = 0;
        int index = 0;
        int roomLevel = 0;
        while (count < roomTotal) {

            if (index == size) {
                if (count != 0) {
                    System.out.println("Waiting!");

                }
                break;
            }

            if (count == 0) {
                System.out.println("Started!");

                for (int i = 0 ; i < size ; i++) {
                    if (!visited[i]) {
                        roomLevel = Integer.parseInt(player[i][0]);
                        visited[i] = true;
                        index = i;
                        count++;
                        System.out.println(player[i][0] + " " + player[i][1]);
                        break;
                    }
                }
            }



            if (!visited[index] && roomLevel - 10 <= Integer.parseInt(player[index][0]) && roomLevel + 10 >= Integer.parseInt(player[index][0])) {
                count++;
                visited[index] = true;
                System.out.println(player[index][0] + " " + player[index][1]);
            }

            index++;



            if (count % roomTotal == 0) {
                count = 0;
            }



        }





    }


}
