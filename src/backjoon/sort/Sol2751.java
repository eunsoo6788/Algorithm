package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Sol2751 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        double[][] arr = new double[num][2];

        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr,(o1,o2) -> {
            if (o1[1] == o2[1]) {
                return Double.compare(o2[0],o1[0]);
            }

            return Double.compare(o2[1],o1[1]);
        });

        System.out.println();

    }


}
