package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for (int num = 1; num <= number; num++) {
            clap += countClaps(num);
        }
        return clap;
    }

    private static int countClaps(int num) {
        int claps = 0;
        while (0 < num) {
            int eachNum = num % 10;
            if (eachNum == 3 || eachNum == 6 || eachNum == 9) {
                claps++;
            }
            num /= 10;
        }
        return claps;
    }
}
