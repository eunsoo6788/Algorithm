package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main5073 {

    /**
     * 삼각형과 세 변
     * 브론즈3
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if (a == 0 && b == 0 && c == 0) {
                break;
            }


            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c - max;

            if (max >= sum) {
                System.out.println("Invalid");
                continue;
            }



            if (a == b && b == c && c == a) {
                System.out.println("Equilateral");
                continue;
            }

            if (a != b && b != c && c != a) {
                System.out.println("Scalene");
                continue;
            }


            if (a == b || b == c || c == a) {
                System.out.println("Isosceles");
            }





        }





    }








}
