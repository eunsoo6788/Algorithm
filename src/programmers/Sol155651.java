package programmers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol155651 {

    public int solution(String[][] book_time) throws Exception {
        int answer = 0;




        LocalDateTime[][] dates = new LocalDateTime[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {

            var start = book_time[i][0].length() == 4 ? "0" + book_time[i][0] : book_time[i][0];
            var end = book_time[i][1].length() == 4 ? "0" + book_time[i][1] : book_time[i][1];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dates[i][0] = LocalDateTime.parse("2024-10-10 " + start, formatter);
            dates[i][1] = LocalDateTime.parse("2024-10-10 " + end, formatter);
        }



        Arrays.sort(dates, (a, b) -> {
            if (a[0].compareTo(b[0]) == 0) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });


        List<BookTime> list = new ArrayList<>();

        for (int i = 0 ; i < dates.length; i++) {

            // 예약된 내역이 없으면 추가
            if (!list.isEmpty()) {

                // 만료된 예약 삭제
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getEnd().plusMinutes(10L).compareTo(dates[i][0]) <= 0) {
                        list.remove(j);
                        j--;
                    }
                }

            }

            // 새로운 예약 추가
            list.add(new BookTime(dates[i][0], dates[i][1]));


            // 예약에 필요한 방 개수 계산
            answer = Math.max(answer, list.size());

        }





        return answer;
    }


    class BookTime {
        LocalDateTime start;
        LocalDateTime end;

        public BookTime(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getEnd() {
            return end;
        }
    }


    public static void main(String[] args) throws Exception {
        Sol155651 sol = new Sol155651();
        String[][] book_time = {{"5:00", "15:00"}, {"10:00", "20:00"}, {"20:30", "23:00"}, {"15:30", "23:30"}};
        System.out.println(sol.solution(book_time));
    }
}
