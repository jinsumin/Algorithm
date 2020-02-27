package level3.translate_bible_7675;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i = 1; i <= testCase; i ++) {
            int numberOfSentence = scanner.nextInt();
            String[] sentence = new String[numberOfSentence];
            for(int j = 0; j < numberOfSentence; j ++) {
                sentence[j] = scanner.next();
            }
            Interpretation interpretation = new Interpretation();
            System.out.println("#" + i + " " + interpretation.countOfName(sentence));
        }
    }
}

class Interpretation {
    public int countOfName(String[] sentence) {
        int count = 0;
        for(int i = 0; i < sentence.length; i ++) {
            String[] a = sentence[i].split(" ");
            for(int j = 0; j < a.length; j ++) {
                for(int k = 0; k < a[j].length(); k ++) {
                    if(k == 0) {
                        if(Character.isUpperCase(a[j].charAt(k))) {
                            continue;
                        }
                    }
                    if(!Character.isLowerCase(a[j].charAt(k))) {
                        break;
                    }
                    count ++;
                }
            }
        }
        return count;
    }
}
