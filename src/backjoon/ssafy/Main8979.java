package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main8979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][5];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[i][0] = country;
            arr[i][1] = gold;
            arr[i][2] = silver;
            arr[i][3] = bronze;
            arr[i][4] = 0;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });


        int rank = 1;
        int same = 0;

        if (arr[0][0] == target) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < num; i++) {

            if (arr[i][1] == arr[i-1][1] && arr[i][2] == arr[i-1][2] && arr[i][3] == arr[i-1][3]) {
                same++;
            } else {
                rank += same + 1;
                same = 0;
            }


            if (arr[i][0] == target) {
                System.out.println(rank);
                break;
            }
        }




    }

}
