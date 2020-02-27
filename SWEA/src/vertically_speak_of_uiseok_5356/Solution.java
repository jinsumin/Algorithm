package vertically_speak_of_uiseok_5356;

import java.util.*;

/**
 * Created by REMI on 2020-01-18.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            Queue[] words = new Queue[5];
            int maxSize = 0;
            for (int i = 0; i < 5; i++) {
                words[i] = new LinkedList<Character>();
                String str = scanner.next();
                for(int j = 0; j < str.length(); j ++) {
                    words[i].offer(str.charAt(j));
                }
                if(str.length() > maxSize) {
                    maxSize = str.length();
                }
            }
            Game game = new Game();
            System.out.println("#" + t + " " + game.play(words, maxSize));
        }
    }
}

class Game {
    public String play(Queue<Character>[] words, int maxSize) {
        String verticalWords = "";
        for(int size = 0; size < maxSize; size ++) {
            for (int i = 0; i < 5; i++) {
                if (!words[i].isEmpty()) {
                    verticalWords += (words[i].poll());
                }
            }
        }
        return verticalWords;
    }
}
