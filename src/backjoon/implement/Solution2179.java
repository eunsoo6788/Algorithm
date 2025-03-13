package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2179 {

    /**
     * 백준 : 비슷한 단어 2179
     * 알고리즘 : 구현 정렬 문자열
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());

        String[][] arr = new String[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = br.readLine();
            arr[i][1] = String.valueOf(i);
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[0]));

        int max = 0;

        List<String[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();


        for (int i = 0; i < num-1; i++) {
            for (int j = i+1; j < num; j++) {

                int minLen = Math.min(arr[i][0].length(), arr[j][0].length());
                int count = 0;

                for (int k = 0; k < minLen; k++) {
                    if (arr[i][0].charAt(k) != arr[j][0].charAt(k)) {
                        break;
                    }
                    count++;
                }

                if (count > max) {
                    max = count;
                    list.clear();
                    set.clear();
                    list.add(new String[] {arr[i][0], arr[i][1]});
                    set.add(Integer.parseInt(arr[i][1]));
                    list.add(new String[] {arr[j][0], arr[j][1]});
                    set.add(Integer.parseInt(arr[j][1]));


                } else if (count == max) {
                    if (!set.contains(Integer.parseInt(arr[i][1]))) {
                        list.add(new String[] {arr[i][0], arr[i][1]});
                        set.add(Integer.parseInt(arr[i][1]));
                    }

                    if (!set.contains(Integer.parseInt(arr[j][1]))) {
                        list.add(new String[] {arr[j][0], arr[j][1]});
                        set.add(Integer.parseInt(arr[j][1]));
                    }

                } else {
                    break;
                }


            }
        }


        list.sort(Comparator.comparing(o -> o[1]));

        System.out.println(list.get(0)[0]);
        System.out.println(list.get(1)[0]);

    }


}
