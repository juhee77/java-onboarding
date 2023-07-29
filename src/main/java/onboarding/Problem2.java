package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (hasDuplicate(answer)) {
            answer = deleteDuplicate(answer);
        }
        return answer;
    }

    private static boolean hasDuplicate(String answer) {
        char before = ' ';
        for (char now : answer.toCharArray()) {
            if (before == now) {
                return true;
            }
            before = now;
        }
        return false;
    }

    private static String deleteDuplicate(String inputString) {
        System.out.println(inputString);
        StringBuilder answer = new StringBuilder();
        char before = ' ';
        boolean isDuplicate = false;

        for (char now : inputString.toCharArray()) {
            if (before == now) {
                if (!isDuplicate) {
                    isDuplicate = true;
                    answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                }
            } else {
                isDuplicate = false;
                answer.append(now);
                before = now;
            }
        }

        return answer.toString().trim();
    }

}
