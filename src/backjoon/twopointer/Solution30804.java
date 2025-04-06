package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution30804 {

    /**
     * 용액 2467
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int low = 0;
        int high = 0;
        int mid = num / 2;


        // 중앙값 계산
        if (num % 2 == 0) {
            low = mid - 1;
            high = mid ;
        } else {
            low = mid;
            high = mid;
        }


        Set<Integer> set = new HashSet<>();

        while (true) {


            if (!set.contains(arr[low]) && !set.contains(arr[high])) {

                if (set.size() + 2 == 4) {
                    System.out.println(high - low -1);
                    break;
                } else if (set.size() +2 == 3) {
                    System.out.println(high - low);
                    break;
                }

            } else if (!set.contains(arr[low]) || !set.contains(arr[high])) {
                if (set.size() + 1 > 2) {
                    System.out.println(high - low);
                    break;
                }
            }

            set.add(arr[low]);
            set.add(arr[high]);

            low--;
            high++;


            // 종료 조건
            if (low == -1 && high == num) {
                System.out.println(num);
                break;
            }
        }




    }
}
