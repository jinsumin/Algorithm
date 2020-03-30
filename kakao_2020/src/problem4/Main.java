package problem4;

import java.util.HashMap;

/**
 * Created by Crab on 2020-03-30.
 */
public class Main {
    public static void main(String[] args) {
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "example";
        Solution solution = new Solution();
        System.out.println(solution.solution(S, C));
    }
}

class Solution {
    private static class People {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String emailAddress = "";
    }

    public String solution(String S, String C) {
        StringBuilder answer = new StringBuilder();
        String[] strings = S.split("; ");
        People[] people = new People[strings.length];
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            people[i] = new People();
            String[] name = strings[i].split(" ");
            if (name.length == 2) {
                people[i].firstName = name[0];
                people[i].lastName = name[1];
            } else {
                people[i].firstName = name[0];
                people[i].middleName = name[1];
                people[i].lastName = name[2];
            }
            people[i].emailAddress = people[i].lastName + "_" + people[i].firstName;
            if (hashMap.containsKey(people[i].emailAddress)) {
                hashMap.put(people[i].emailAddress, (int)((int)hashMap.get(people[i].emailAddress) + 1));
                people[i].emailAddress += hashMap.get(people[i].emailAddress);
            } else {
                hashMap.put(people[i].emailAddress, 1);
            }
            people[i].emailAddress = people[i].emailAddress.replace("-", "");
        }
        for (People person : people) {
            answer.append(person.firstName).append(" ");
            if (person.middleName.length() > 1) {
                answer.append(person.middleName).append(" ");
            }
            answer.append(person.lastName).append(" ");
            answer.append("<").append(person.emailAddress.toLowerCase()).append("@").append(C.toLowerCase()).append(".com>; ");
        }
        return answer.substring(0, answer.length() - 2);
    }
}
