package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main23971 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int redY = y / (n + 1);
        int nY = y % (n + 1) == 0 ? 0 : 1;

        int redX = x / (m + 1);
        int nX = x % (m + 1) == 0 ? 0 : 1;


        System.out.println((redY + nY) * (redX + nX));






    }

}
