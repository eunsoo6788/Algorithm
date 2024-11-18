package programmers;

public class Sol147355 {

    public int solution(String t, String p) {
        int answer = 0;


        for (int i = 0 ; i < t.length() - p.length() +1; i++) {
            String sub = t.substring(i, i+p.length());



            if (Long.parseLong(sub) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        Sol147355 sol = new Sol147355();
        String t = "10203";
        String p = "15";
        System.out.println(sol.solution(t, p));
    }

}
