package moi.treasure_box_password_5658;

import java.util.*;

/**
 * Created by REMI on 2020-01-30.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            int numberOfNumbers = scanner.nextInt();
            int k = scanner.nextInt();
            String[] number = new String[numberOfNumbers];
            for(int i = 0; i < numberOfNumbers; i ++) {
                number[i] = scanner.next();
            }
            TreasureBox treasureBox = new TreasureBox();
            System.out.println("#" + t + " " + treasureBox.solve(number, k));
        }
    }
}

class TreasureBox {
    private List<String> list = new LinkedList<>();
    private ArrayList<Integer> arr = new ArrayList<>();

    public int solve(String[] number, int k) {
        int password = 0;
        list.addAll(Arrays.asList(number));
        for(int i = 0; i < 3; i ++) {
            pushList();
            rotate();
        }
        HashSet<Integer> arr2 = new HashSet<>(arr);         // 중복 숫자 제거
        ArrayList<Integer> arr3 = new ArrayList<>(arr2);    // 정렬해주기 위한 자료구조
        arr3.sort(Comparator.reverseOrder());               // 정렬

        password = arr3.get(k);                             // k 번째 큰수 반환
        return password;
    }

    public void rotate() {
        for(int i = 0; i < list.size(); i ++) {
            if(i == 0) {
                char prevLast = list.get(list.size() - 1).charAt(list.get(list.size() - 1).length() - 1);
                list.set(i, prevLast + list.get(i));
                list.set(list.size() - 1, list.get(list.size() - 1).substring(list.get(list.size() - 1).length() - 2));
                continue;
            }
            char prevLast = list.get(i - 1).charAt(list.get(i - 1).length() - 1);
            list.set(i, prevLast + list.get(i));
            list.set(i - 1, list.get(i - 1).substring(0, list.get(i - 1).length() - 2));
        }
    }

    private void pushList() {
        for(int i = 0; i < list.size(); i ++) {
            arr.add(Integer.parseInt(list.get(i), 16));
        }
    }
}
