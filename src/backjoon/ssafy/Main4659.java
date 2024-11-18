package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main4659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            String str = br.readLine();

            if ("end".equals(str)) {
                break;
            }

            boolean isVowel = false;
            boolean isConsonant = true;
            boolean isDouble = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    isVowel = true;
                }

                if (i < str.length() - 2 && str.length() >=3) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        if (str.charAt(i + 1) == 'a' || str.charAt(i + 1) == 'e' || str.charAt(i + 1) == 'i' || str.charAt(i + 1) == 'o' || str.charAt(i + 1) == 'u') {
                            if (str.charAt(i + 2) == 'a' || str.charAt(i + 2) == 'e' || str.charAt(i + 2) == 'i' || str.charAt(i + 2) == 'o' || str.charAt(i + 2) == 'u') {
                                isConsonant = false;
                            }
                        }
                    }

                    if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                        if (str.charAt(i + 1) != 'a' && str.charAt(i + 1) != 'e' && str.charAt(i + 1) != 'i' && str.charAt(i + 1) != 'o' && str.charAt(i + 1) != 'u') {
                            if (str.charAt(i + 2) != 'a' && str.charAt(i + 2) != 'e' && str.charAt(i + 2) != 'i' && str.charAt(i + 2) != 'o' && str.charAt(i + 2) != 'u') {
                                isConsonant = false;
                            }
                        }
                    }

                }

                if (i < str.length() - 1 && str.length() >= 2) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        if (str.charAt(i) != 'e' && str.charAt(i) != 'o') {
                            isDouble = false;
                        }
                    }
                }


            }


            if (isVowel && isConsonant && isDouble) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");

            }
        }

    }



}
