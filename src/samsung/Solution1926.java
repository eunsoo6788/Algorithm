package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1926 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {

            int size = sc.nextInt();
            int[] prices = new int[size];

            // array 저장
            for (int i = 0; i < size; i++) {
                prices[i] = sc.nextInt();
            }

            long benefit = 0;
            Queue<Integer> buyList = new LinkedList<>();
            int max = 0;
            int index = 0;


            // 전체 for문 돌면서 i보다 큰 값이 있으면 매수 없으면
            for (int i = 0; i < size; i++) {

                // 최대값이 0 일때만 최대값을 구한다
                if (max == 0) {
                    for (int j = i + 1; j < size; j++) {
                        if (max < prices[j]) {
                            max = prices[j];
                            index = j;
                        }
                    }
                }


                // 최대 판매일 일떄 판매
                if (index == i) {
                    while (!buyList.isEmpty()) {
                        int value = buyList.poll();
                        benefit += (max - value);
                    }

                    max = 0;
                }


                if (max > prices[i]) {
                    buyList.add(prices[i]);
                }


            }

            System.out.println("#" + test_case + " " + benefit);

        }


    }

}
