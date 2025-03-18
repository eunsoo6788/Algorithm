package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution17609 {

    /**
     * 회문 17609
     * 알고리즘 : 그리디
     * not sol
     * 골드5
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String s = br.readLine();

            int left = 0;
            int right = s.length()-1;
            boolean similar = false;
            boolean notSimilar = false;
            while (left < right) {

                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else if (s.charAt(left) == s.charAt(right-1)) {
                    if (similar) {
                        notSimilar = true;
                        break;
                    }

                    similar = true;
                    left++;
                    right-=2;

                } else if (s.charAt(left+1) == s.charAt(right)) {
                    if (similar) {
                        notSimilar = true;
                        break;
                    }

                    similar = true;
                    left += 2;
                    right--;
                } else {
                    notSimilar = true;
                    break;
                }

            }

            if (notSimilar) {
                System.out.println(2);
                continue;
            }

            if (similar) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }



        }





    }

}
