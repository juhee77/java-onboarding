package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyList = new ArrayList<>(List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1));

        for (int e : moneyList) {
            answer.add(money / e);
            money %= e;
        }
        return answer;
    }
}
