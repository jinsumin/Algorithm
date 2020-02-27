package create_password_1759_2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by REMI on 2020-01-17.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private final Set<String> alphabet = new HashSet<>();
    private final Set<String> copiedAlphabet = new HashSet<>();
    private final static String MOTHER_SOUND = "aeiou";

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int n = sc.nextInt();

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character c = sc.next().charAt(0);
            chars.add(c);
        }

        Collections.sort(chars);

        for (int i = 0; i < n; i++) {
            copiedAlphabet.addAll(alphabet);
            final char key = chars.get(i);
            copiedAlphabet.forEach(s -> alphabet.add(s + key));
            alphabet.add(String.valueOf(chars.get(i)));
        }

        alphabet.stream()
                .filter(s -> s.length() == r)
                .filter(s -> {
                    long countOfMotherSound =
                            MOTHER_SOUND.chars().mapToObj(c -> (char)c).collect(Collectors.toList()).stream()
                                    .filter(character -> s.contains(String.valueOf(character))).count();
                    return (r - countOfMotherSound) >= 2 && countOfMotherSound >= 1;
                })
                .sorted()
                .forEach(System.out::println);
    }
}
