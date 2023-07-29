package onboarding;

import java.util.List;

class Problem1 {
    private static final int START_PAGE = 1;
    private static final int FINAL_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isValidate(pobi) && isValidate(crong)) {
            int pobiMax = findMaxNum(pobi);
            int crongMax = findMaxNum(crong);

            return findWinner(pobiMax, crongMax);
        } else {
            return -1;
        }
    }

    private static int findWinner(int pobiMax, int crongMax) {
        if (pobiMax == crongMax) return 0;
        if (pobiMax < crongMax) return 2;
        return 1;
    }

    private static int findMaxNum(List<Integer> client) {
        int leftMax = Math.max(multiply(client.get(0)), add(client.get(0)));
        int rightMax = Math.max(multiply(client.get(0)), add(client.get(0)));
        return Math.min(leftMax, rightMax);
    }

    private static int add(Integer number) {
        int sum = 0;
        while (0 < number) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int multiply(Integer number) {
        int sum = 1;
        while (0 < number) {
            sum *= number % 10;
            number /= 10;
        }
        return sum;
    }

    private static boolean isValidate(List<Integer> client) {
        int left = client.get(0);
        int right = client.get(1);
        if (left + 1 == right) {
            return isValidePage(left) || isValidePage(right);
        }
        return false;
    }

    private static boolean isValidePage(int page) {
        if (page < START_PAGE || FINAL_PAGE < page) {
            return false;
        }
        return true;
    }
}