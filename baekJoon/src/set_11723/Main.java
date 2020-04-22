package set_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-04-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfOperation = Integer.parseInt(stringTokenizer.nextToken());
        int[] set = new int[21];
        for (int i = 0; i < numberOfOperation; i++) {
            String[] tokens = bufferedReader.readLine().split(" ");
            int temp = 0;
            if (tokens.length > 1) {
                temp = Integer.parseInt(tokens[1]);
            }
            switch (tokens[0]) {
                case "add":
                    set[temp] = temp;
                    break;
                case "remove":
                    set[temp] = 0;
                    break;
                case "check":
                    if (set[temp] != 0) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "toggle":
                    if (set[temp] == 0) {
                        set[temp] = Integer.parseInt(tokens[1]);
                    } else {
                        set[temp] = 0;
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j ++) {
                        set[j] = j;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j ++) {
                        set[j] = 0;
                    }
                    break;
            }
        }
    }
}
