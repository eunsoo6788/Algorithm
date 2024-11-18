package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];
        int lastTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            var startTime = st.nextToken();
            var endTime = st.nextToken();

            lastTime = Math.max(lastTime, Integer.parseInt(endTime));

            times[i][0] = Integer.parseInt(startTime);
            times[i][1] = Integer.parseInt(endTime);
        }

        var result = solve(times, N);

        System.out.println(result);

    }


    private static int solve (int[][] times, int lastTime) {

        List<TimeTable> sortedTimes = new ArrayList<>();

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        int max = 0;
        int count = 0;

        for (int i = 0; i <= times[lastTime-1][0]; i++) {

            if (i == times[count][0]) {
                sortedTimes.add(new TimeTable(times[count][0], times[count][1]));
                count++;
            }



            for (int j = 0 ; j < sortedTimes.size() ; j++) {
                if ( times[count][0] > sortedTimes.get(j).getEndTime() ) {
                    sortedTimes.remove(j);
                }
            }


            max = Math.max(max, sortedTimes.size());
        }

        return max;

    }


    static class TimeTable {
        private int startTime;
        private int endTime;

        public TimeTable(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return this.startTime;
        }

        public int getEndTime() {
            return this.endTime;
        }
    }


}
