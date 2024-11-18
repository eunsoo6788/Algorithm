package programmers;

public class Sol142086 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        answer[0] = -1;

        for (int i = 1; i < s.length(); i++) {


            if (answer[i] == 0 ){
                int add = 1;
                answer[i] = -1;

                for (int j = i+1; j < s.length(); j++) {

                    if (s.charAt(i) == s.charAt(j)) {
                        answer[j] = add;
                        add = 1;
                    } else {
                        add++;
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Sol142086 sol = new Sol142086();
        String s = "foobar";
        System.out.println(sol.solution(s));
    }

}
