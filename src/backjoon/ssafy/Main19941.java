package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19941 {

    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int scope = Integer.parseInt(st.nextToken());


        String str = br.readLine();
        boolean[] visited = new boolean[size];

        for (int i = 0 ; i < size ; i++) {

            if (str.charAt(i) == 'H') {
                continue;
            }

            for (int j = i - scope ; j <= i + scope ; j++) {
                if (j < 0 || j >= size) {
                    continue;
                }

                if (str.charAt(j) == 'H' && !visited[j]) {
                    visited[j] = true;
                    break;
                }

            }


        }


        int count = 0;
        for (int i = 0 ; i < size ; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);



    }


}
