package bestseller_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-07-29.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            String bookName = bufferedReader.readLine();
            if (hashMap.containsKey(bookName)) {
                hashMap.put(bookName, hashMap.get(bookName) + 1);
            } else {
                hashMap.put(bookName, 1);
            }
        }
        List<String> list = new ArrayList<>(hashMap.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                Integer val1 = hashMap.get(key1);
                Integer val2 = hashMap.get(key2);
                if (val1.equals(val2)) {
                    return key1.compareTo(key2);
                } else {
                    return val2.compareTo(val1);
                }
            }
        });
        System.out.println(list.iterator().next());
    }
}
