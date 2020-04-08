package self_number_4673;

/**
 * Created by Crab on 2020-03-31.
 */

public class Main {
    public static void main(String[] args) {


        int[] Group = new int[10001];

        for (int i = 0; i < 10001; i++) {
            int SelfNumber = getDn(i);
            if (SelfNumber < 10001) {
                Group[i] = 1;
            }
        }
        for (int j = 0; j < 10001; j++) {
            if (Group[j] == 1) {
                System.out.println(j);
            }
        }


    }

    static int getDn(int n) {
        int SelfNumber = n;
        while (n > 0) {
            SelfNumber += n % 10;
            n /= 10;
        }
        return SelfNumber;
    }
}