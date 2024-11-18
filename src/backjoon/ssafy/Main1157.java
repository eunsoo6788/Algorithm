package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();


        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        String[][] arr = new String[map.size()][2];

        for (int i = 0; i < map.size(); i++) {
            var key = map.keySet().toArray()[i];
            arr[i][0] = String.valueOf(key);
            arr[i][1] = String.valueOf(map.get(key));
        }

        Arrays.sort(arr, (o1, o2) -> {
            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });


        if (arr.length >= 2 && arr[0][1].equals(arr[1][1])) {
            System.out.println("?");
        } else {
            System.out.println(arr[0][0]);
        }






    }

}
