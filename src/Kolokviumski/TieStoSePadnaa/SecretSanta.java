package Kolokviumski.TieStoSePadnaa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecretSanta {
    public static void main(String[] args) {
        int Q;
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split("\\s+");
        Q = Integer.parseInt(nums[2]);
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for (int i = 0; i < Q; i++) {
            String[] line = sc.nextLine().split("\\s+");
            if (line[0].equals("wish")) {
                String personFrom = line[1];
                String personTo = line[2];

                if (!map.containsKey(personFrom)) {
                    map.put(personFrom, new HashMap<>());
                }
                if (!map.get(personFrom).containsKey(personTo)) {
                    map.get(personFrom).put(personTo, 0);
                }

                map.get(personFrom).put(personTo, map.get(personFrom).get(personTo) + 1);

            } else if (line[0].equals("ask")) {
                if (line[1].equals("employee")) {
                    String person = line[2];
                    Map<String, Integer> peopleMap = map.get(person);

                    int numberOfPeopleToGive = peopleMap.size();
                    System.out.println(numberOfPeopleToGive);

                } else if (line[1].equals("pair")) {

                    String person1 = line[2];
                    String person2 = line[3];

                    Map<String, Integer> peopleMap1 = map.get(person1);
                    Map<String, Integer> peopleMap2 = map.get(person2);

                    System.out.println(peopleMap1.get(person2) + peopleMap2.get(person1));
                }
            }
        }
    }
}
