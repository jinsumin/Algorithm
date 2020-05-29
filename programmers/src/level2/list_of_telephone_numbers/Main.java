package level2.list_of_telephone_numbers;


/**
 * Created by Crab on 2020-05-26.
 */
public class Main {
    public static void main(String[] args) {
        String[] phone_book = {
                "12",
                "123",
                "1235",
                "567",
                "88"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(phone_book));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i ++) {
            for (int j = 0; j < phone_book.length; j ++) {
                if (i == j) {
                    continue;
                }
                if (phone_book[i].length() > phone_book[j].length()) {
                    if (phone_book[i].startsWith(phone_book[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
