package programmers;

import java.util.Arrays;

public class Solution12915 {

    public String[] solution(String[] strings, int n) {

        // 2차원 배열 생성 (문자열, 문자열의 n번째 문자)
        String[][] arr = new String[strings.length][2];

        for (int i = 0; i < strings.length ; i++) {
            arr[i][0] = strings[i];
            arr[i][1] = strings[i].charAt(n) + "";
        }


        // 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                return o1[0].compareTo(o2[0]);
            } else {
                return o1[1].compareTo(o2[1]);
            }
        });


        String[] answer = new String[arr.length];

        for (int i = 0 ; i < arr.length ; i++) {
            answer[i] = arr[i][0];
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution12915 sol = new Solution12915();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(sol.solution(strings, n)));
    }

}
