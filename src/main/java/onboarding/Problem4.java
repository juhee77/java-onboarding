package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            char append = c;
            if ('a' <= c && c <= 'z') {
                append = (char) ('z' - (c - 'a'));
            } else if ('A' <= c && c <= 'Z') {
                append = (char) ('Z' - (c - 'A'));
            }
            answer.append(append);
        }
        return answer.toString();
    }
}
