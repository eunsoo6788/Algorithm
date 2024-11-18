package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int a = Math.max(y, Math.max(x, n));

            if ((y+x+n) - a <= a) {
                System.out.println("Invalid");
                continue;
            }



            if (y == x && x == n) {
                System.out.println("Equilateral");
                continue;
            }

            if (y == x || y == n) {
                System.out.println("Isosceles");
                continue;
            }

            if (x == y || x == n) {
                System.out.println("Isosceles");
                continue;
            }

            if (n == y || n == x) {
                System.out.println("Isosceles");
                continue;
            }

            if (y != x && x != n && n != y) {
                System.out.println("Scalene");
                continue;
            }



            if (y == 0 && x == 0 && n == 0) {
                break;
            }
        }











    }

}
