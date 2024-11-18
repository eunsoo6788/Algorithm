package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();	// 나이
            arr[i][1] = st.nextToken();	// 이름
        }

        Arrays.stream(arr).sorted((o1, o2) -> {
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        }).forEach(s -> System.out.println(s[0] + " " + s[1]));



    }
}
