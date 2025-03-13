package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2631 {

    /**
     * 백준 : 줄세우기 2631
     * 알고리즘 : 구현
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
            diff.add(Math.abs(list.get(i) - i + 1));
        }

        System.out.println();

        boolean match = true;
        int count = 0;
        while (true) {

            int max = 0;
            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                if (diff.get(i) != 0) {
                    match = false;

                    if (max < diff.get(i)) {
                        max = diff.get(i);
                        maxIndex = i;
                    }
                }
            }

            if (match) {
                break;
            }

            count++;

            int value = list.get(maxIndex);
            list.remove(maxIndex);
            list.add(value-1,value);

            if (maxIndex > value-1) {
                for (int i = maxIndex - 1; i >= value-1; i--) {
                    diff.set(i, diff.get(i) + 1);
                }


            } else {
                for (int i = maxIndex + 1; i <= value-1; i++) {
                    diff.set(i, diff.get(i) - 1);
                }

            }

            diff.remove(maxIndex);
            diff.add(value-1,0);


        }


        System.out.println(count);



    }


}
