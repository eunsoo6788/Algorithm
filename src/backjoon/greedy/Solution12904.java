package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12904 {

    /**
     * A와 B 12904
     * 알고리즘 : 그리디
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String now = br.readLine();

        boolean reverse = false;

        while (now.length() > origin.length()) {

            char tmp = ' ';

            if (!reverse) {
                tmp = now.charAt(now.length()-1);
                now = now.substring(0, now.length()-1);
            } else {
                tmp = now.charAt(0);
                now = now.substring(1, now.length());
            }


            if (tmp == 'B') {
                reverse = !reverse;
            }
        }

        if (!reverse) {
            if (now.equals(origin)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            boolean flag = false;

            for (int i = 0; i < origin.length(); i++) {
                if (now.charAt(i) != origin.charAt(origin.length() -1 - i)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }


    }

}
