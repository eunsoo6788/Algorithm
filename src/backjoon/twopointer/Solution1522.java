package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1522 {

    /**
     * 문자열 교환
     * 투 포인터
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int left = 0;
        int right = str.length()-1;
        int count = 0;

        if (str.charAt(0)=='b' && str.charAt(str.length()-1) == 'b') {
            left++;
            right--;
        }

        while (left < right) {


            if (str.charAt(left) == 'a' && str.charAt(right) == 'b') {
                left++;
                right--;
                count++;
            } else if (str.charAt(left) == 'a') {
                right--;
            } else if (str.charAt(left) == 'b') {
                left++;
            }
        }


        left = 0;
        right = str.length()-1;
        int count2 = 0;

        if (str.charAt(0)=='a' && str.charAt(str.length()-1) == 'a') {
            left++;
            right--;
        }


        while (left < right) {
            if (str.charAt(left) == 'b' && str.charAt(right) == 'a') {
                left++;
                right--;
                count2++;
            } else if (str.charAt(left) == 'b') {
                right--;
            } else if (str.charAt(left) == 'a') {
                left++;
            }
        }

        System.out.println(Math.min(count, count2));

    }
}
