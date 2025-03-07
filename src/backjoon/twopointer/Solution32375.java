package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution32375 {

    /**
     * 불꽃놀이 32375
     * 알고리즘 : 투 포인터
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int minLimit = Integer.parseInt(st.nextToken());
        int overLimitCount = 0;

        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= minLimit) {
                overLimitCount++;
            }
        }

        Arrays.sort(arr);

        int underLimitCount = num - overLimitCount;
        int[] underLimitArr = new int[underLimitCount];
        boolean[] visited = new boolean[underLimitCount];

        Set<Integer> overLimitSet = new HashSet<>();

        for (int i = 0; i < underLimitCount; i++) {
            underLimitArr[i] = arr[i];
        }

        for (int i = underLimitCount; i < num; i++) {
            overLimitSet.add(arr[i]);
        }


        int left = 0;
        int right = 1;

        while (right < overLimitCount) {

            int sum = underLimitArr[left] + underLimitArr[right];

            if (sum >= minLimit) {

                while (left < right-1) {
                    left++;
                    if (underLimitArr[left] + underLimitArr[right] >= minLimit && !visited[left] && !visited[right]) {
                        if (!overLimitSet.contains(sum)) {
                            overLimitSet.add(sum);
                            visited[left] = true;
                            left++;
                            visited[right] = true;
                            break;
                        }
                    }
                }
                right++;


            } else {
                while (left < right-1) {
                    left++;
                    if (underLimitArr[left] + underLimitArr[right] >= minLimit && !visited[left] && !visited[right]) {
                        if (!overLimitSet.contains(sum)) {
                            overLimitSet.add(sum);
                            visited[left] = true;
                            left++;
                            visited[right] = true;
                            break;
                        }
                    }
                }
                right++;
            }

        }

        if (overLimitSet.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(overLimitSet.size());
        }

    }
}
