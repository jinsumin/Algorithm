import java.util.*;

/**
 * Created by REMI on 2020-01-01.
 */


public class Main {

    public static void main(String[] args){
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution sol = new Solution();
        System.out.println(sol.solution(clothes));



//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("김태희", 90);
//        map.put("전혜빈", 80);
//        map.put("유인나", 100);
//        map.put("아이유", 90);
//
//        if(map.containsKey("유인나")) {
//            System.out.println("유인나 있음");
//        }
//
//        if(map.containsValue(90)) {
//            System.out.println("value 값 90 있음");
//        }
//
//        Set<Map.Entry<String, Integer>> set = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = set.iterator();
//        while(it.hasNext()){
//            Map.Entry<String, Integer> e = it.next();
//            System.out.println("이름 " + e.getKey() + " 점수" + e.getValue());
//        }
//        Set<String> set2 = map.keySet();
//        System.out.println("참가자 명단: " + set2);
//
//        Iterator<Integer> it2;
//        Collection<Integer> values = map.values();
//        it2 = values.iterator();
//
//        int total = 0;
//        while(it2.hasNext()){
//            total += it2.next();
//        }
//
//        System.out.println("총점 : " + total);
//        System.out.println("최고점수 : " + Collections.max(values));
//        System.out.println("최저점수 : " + Collections.min(values));
//



    }
}

class Solution {

    private static HashMap<String, Integer> hashMapClothes = new HashMap<String, Integer>();

    public int solution(String[][] clothes) {
        int answer = 0;
        for(int i = 0; i < clothes.length; i ++) {
            if(hashMapClothes.containsKey(clothes[i][1])) {
                hashMapClothes.replace(clothes[i][1], hashMapClothes.get(clothes[i][1]) + 1);
            }else {
                hashMapClothes.put(clothes[i][1], 1);
            }
        }
        int temp = 1;
        Set<Map.Entry<String, Integer>> set = hashMapClothes.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            temp *= (entry.getValue() + 1);
        }
        answer = temp - 1;
        return answer;
    }
}
