package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2872 {

    /**
     * 백준 : 우리집엔 도서관이 있어 2872
     * 알고리즘 : 그리디
     * not sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0 ; i < num ; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;

        while (true) {


            int invalidIndex = 0;
            int invalidMaxValue = arr.get(0);
            int invalidValue = arr.get(0);


            for (int i  = 0 ; i < num -1 ; i++) {

                if (arr.get(i) < invalidValue) {
                    invalidValue = arr.get(i);

                    if (invalidMaxValue < arr.get(i)) {
                        invalidIndex = i;
                        invalidMaxValue = arr.get(i);
                    }
                }
            }

            if (invalidIndex == 0 ) {
                break;
            }

            arr.remove(invalidIndex);
            arr.add(invalidMaxValue);
            count++;
        }


    }

}
