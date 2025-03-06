package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution16472 {

    /**
     * 고냥이 16472
     * 알고리즘 : 투 포인터
     * sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();


        int left = 0;
        int right = 0;

        int len = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {

            if (map.containsKey(str.charAt(right)) || map.keySet().size() < num) {
                map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
                len = Math.max(len, right - left + 1);
                right++;
            } else {

                int count = map.getOrDefault(str.charAt(left), 0);

                if (count > 1) {
                    map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0) - 1);
                    left++;
                } else {
                    map.remove(str.charAt(left));
                    left++;
                }
            }


        }

        System.out.println(len);

    }
}
