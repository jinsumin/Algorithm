package level3.dasol_pay_box_6692;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i = 1; i <= testCase; i ++) {
            PayBox paybox = new PayBox();
            int chance = scanner.nextInt();
            double[] percentage = new double[chance];
            double[] pay = new double[chance];
            for(int j = 0; j < chance; j ++) {
                percentage[j] = scanner.nextDouble();
                pay[j] = scanner.nextDouble();
            }
            System.out.println("#" + i + " " + paybox.estimatedSalary(chance, percentage, pay));
        }
    }
}

class PayBox {
    public double estimatedSalary(int chance, double[] percentage, double[] pay) {
        double salary = 0;
        for(int i = 0; i < chance; i ++) {
            salary += (double)((double)pay[i] * (double)percentage[i]);
        }
        return salary;
    }
}
