package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution20437 {

    /**
     * 문자열 게임2 20437
     * 골드5
     * 알고리즘 : 슬라이딩 윈도우
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testSize = Integer.parseInt(br.readLine());


        for (int testCase = 0 ; testCase < testSize ; testCase++) {


            Map<Character, Integer> map = new HashMap<>();

            String str = br.readLine();
            int size = Integer.parseInt(br.readLine());


            int left = 0;
            int right = 0;
            int min = Integer.MAX_VALUE;
            int max = 0;


            while (left <= right) {

                if (right == str.length()) {
                    break;
                }

                map.put(str.charAt(right), map.getOrDefault(str.charAt(right),0) +1);


                if (map.getOrDefault(str.charAt(right), 0) == size) {

                    for (int i = left ; i < right ; i++) {
                        if (str.charAt(i) == str.charAt(right)) {
                            break;
                        } else {
                            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) -1);
                        }
                    }

                    int sum = 0;
                    for (int i : map.values()) {
                        sum += i;
                    }

                    min = Math.min(min, sum);
                    max = Math.max(max,sum);


                    for (int i = left ; i < right ; i++) {
                        if (str.charAt(i) == str.charAt(right)) {
                            break;
                        } else {
                            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) +1);
                        }
                    }
                }

                map.put(str.charAt(left), map.getOrDefault(str.charAt(left),0) -1);
                right++;
                left++;


            }




            if (min >= Integer.MAX_VALUE || max == 0) {
                System.out.println(-1);
                return;
            }

            System.out.println(min +" " +max);


        }




    }



}
