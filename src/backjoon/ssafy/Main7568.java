package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        int[][] arr = new int[num][4];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = height;
            arr[i][2] = i+1;

        }


        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });


        int rank = 1;
        int same = 0;

        arr[num-1][3] = rank;

        for (int i = num-2; i > 0; i--) {

            if (arr[i][0] > arr[i-1][0] && arr[i][1] > arr[i-1][1]) {
                arr[i][3] = rank + same + 1;
                same = 0;
            } else {
                arr[i][3] = arr[i-1][3];
                same++;
            }
        }



        Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i][3] + " ");
        }


    }

}
