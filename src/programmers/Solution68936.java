package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution68936 {

    private static int zero = 0;
    private static int one = 0;

    public int[] solution(int[][] arr) {

        int size = arr.length;

        dfs(arr, size, 0, 0, 0);


        return new int[]{zero, one};
    }

    private void dfs(int[][] arr, int size, int depth, int x, int y) {

        if (size == 1) {

            if (arr[x][y] == 0) {
                zero++;
            } else {
                one++;
            }

            return;
        }


        boolean flag = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != arr[x][y]) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }


        if (flag) {
            if (arr[x][y] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }


        dfs(arr, size/2, depth + 1, x, y);
        dfs(arr, size/2, depth + 1, x + size/2, y);
        dfs(arr, size/2, depth + 1, x, y + size/2);
        dfs(arr, size/2, depth + 1, x + size/2, y + size/2);


    }

    public static void main(String[] args) {
        Solution68936 solution68936 = new Solution68936();
        System.out.println(Arrays.toString(solution68936.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

}
