package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> eachFriends = new HashMap<>();
        HashMap<String, Integer> recommendedFriends = new HashMap<>();

        for (List<String> friend : friends) {
            String first = friend.get(0);
            String second = friend.get(1);
            List<String> firstFriends = eachFriends.getOrDefault(first, new ArrayList<>());
            firstFriends.add(second);
            eachFriends.put(first, firstFriends);

            List<String> secondFriends = eachFriends.getOrDefault(second, new ArrayList<>());
            secondFriends.add(first);
            eachFriends.put(second, secondFriends);
        }

        //이미 친구인 친구 확인//친구의 친구에게 +10
        for (String friend : eachFriends.get(user)) {
            List<String> friendOfFriends = eachFriends.get(friend);
            for (String friendOfFriend : friendOfFriends) {
                recommendedFriends.put(friendOfFriend, recommendedFriends.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        for (String friend : visitors) {
            recommendedFriends.put(friend, recommendedFriends.getOrDefault(friend, 0) + 1);
        }

        recommendedFriends.remove(user);
        for (String alreadyFriend : eachFriends.get(user)) {
            recommendedFriends.remove(alreadyFriend);
        }

        List<Map.Entry<String, Integer>> sortFiends = recommendedFriends.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        }).collect(Collectors.toList());

        for (int i = 0; i < Math.min(5, sortFiends.size()); i++) {
            answer.add(sortFiends.get(i).getKey());
        }

        return answer;
    }
}
