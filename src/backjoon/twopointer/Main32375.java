//package backjoon.twopointer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main32375 {
//
//    /**
//     * 수 고르기
//     * 투 포인터
//     * 골드5
//     */
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int num = Integer.parseInt(st.nextToken());
//        long limit = Integer.parseInt(st.nextToken());
//
//        List<Long> list = new ArrayList<>();
//        Set<Long> set = new HashSet<>();
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < num; i++) {
//            long value = Long.parseLong(st.nextToken());
//
//            if (value >= limit) {
//                set.add(value);
//            } else {
//                list.add(Long.parseLong(st.nextToken()));
//            }
//
//        }
//
//        list.sort(Comparator.naturalOrder());
//
//
//        int low = 0 ;
//        int high = 0;
//
//        long min = Long.MAX_VALUE;
//
//        while (high < num) {
//
//            long abs = Math.abs(arr[low] - arr[high]);
//
//            if (abs < limit) {
//                high++;
//            } else if (abs == limit) {
//                min = limit;
//                break;
//            } else {
//                low++;
//                min = Math.min(abs, min);
//            }
//
//        }
//
//        System.out.println(min);
//
//
//    }
//}
