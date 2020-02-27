package numbers_of_village_7465;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-18.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int t = 1; t <= testCase; t ++) {
            Village village = new Village();
            village.grouping();
            System.out.println("#" + t + " " + village.countGroup());
        }
    }
}

class Village {
    private static Scanner scanner = new Scanner(System.in);
    private static List<List<Integer>> list = new LinkedList<>();
    public void grouping() {
        int numberOfPeople = scanner.nextInt();
        int numberOfRelation = scanner.nextInt();
        for(int i = 0; i < numberOfRelation; i ++) {
            int person1 = scanner.nextInt();
            int person2 = scanner.nextInt();
            addList(person1, person2);
        }
    }

    private void addList(int person1, int person2) {
        for(int i = 0; i < list.size(); i ++) {
            Iterator<Integer> iterator = list.get(i).iterator();
            while (iterator.hasNext()) {
                int temp = iterator.next();
                if (temp == person1) {
                    list.get(i).add(person2);
                    return;
                }
            }
        }
        List<Integer> tempList = new LinkedList<>();
        tempList.add(person1);
        tempList.add(person2);
        list.add(tempList);
    }

    public int countGroup() {
        return list.size();
    }
}
