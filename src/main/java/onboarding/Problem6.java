package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> result = new HashSet<>();
        HashMap<String, String> allNameSet = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0).trim();
            String name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String subName = name.substring(i, i + 2);
                if (allNameSet.containsKey(subName)) {
                    result.add(email);
                    result.add(allNameSet.get(subName));
                }
                allNameSet.put(subName, email);
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }
}
