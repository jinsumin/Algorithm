package level2.cache_kakao_2018;

import java.util.*;

/**
 * Created by Crab on 2020-05-06.
 */
public class Main {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {
                "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(cacheSize, cities));
    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        boolean flag;
        for (int i = 0; i < cities.length; i ++) {
            cities[i] = cities[i].toLowerCase();
        }
        for (String city : cities) {
            if (arrayList.size() < cacheSize) {
                int temp = 0;
                flag = true;
                int size = arrayList.size();
                for (int j = 0; j < size; j++) {
                    if (arrayList.get(j).equals(city)) {
                        temp = j;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer += 5;
                } else {
                    answer += 1;
                    arrayList.remove(temp);
                }
            } else {
                flag = true;
                int temp = 0;
                int size = arrayList.size();
                for (int j = 0; j < size; j++) {
                    if (arrayList.get(j).equals(city)) {
                        temp = j;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer += 5;
                    if (arrayList.size() != 0) {
                        arrayList.remove(0);
                    }
                } else {
                    answer += 1;
                    arrayList.remove(temp);
                }
            }
            if (cacheSize != 0) {
                arrayList.add(city);
            }
            //System.out.println(answer);
            //System.out.println(arrayList);
        }
        return answer;
    }
}
