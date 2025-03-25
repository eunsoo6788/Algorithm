package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution20437Re {

    /**
     * 문자열 게임2  20437
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCount; i++) {

            String str = br.readLine();
            int targetCount = Integer.parseInt(br.readLine());


            int left = 0 ;
            int right = 0 ;

            int min = Integer.MAX_VALUE;
            int minLeft = 0;
            int minRight = 0;


            Map<Character, Integer> map = new HashMap<>();

            while (right < str.length()) {

                map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);

                if (map.get(str.charAt(right)) == targetCount) {
                    while (true) {
                        if (str.charAt(left) == str.charAt(right)) {

                            minLeft = left+1;
                            minRight = right;
                            System.out.println(minRight - minLeft);


                            map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0) - 1);
                            left++;

                            break;
                        } else {
                            map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0) - 1);
                            left++;
                        }
                    }
                }

                right++;
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            }



        }



    }
}
