package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution2872Re {

    /**
     * 우리집엔 도서관이 있어
     * 그리디
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0 ; i < num ; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }


        for (int i = 1; i < num; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) >= arr.get(i)) {

                }
            }
        }

    }

}
