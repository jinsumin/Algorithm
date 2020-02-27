package level3.a_fly_between_trains_6019;

import java.util.Scanner;

/**
 * Created by REMI on 2020-01-15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i = 1; i <= testCase; i ++) {
            TrainAndFly trainAndFly = new TrainAndFly();
            int trainDistance = scanner.nextInt();
            int speedOfTrainA = scanner.nextInt();
            int speedOfTrainB = scanner.nextInt();
            int speedOfFly = scanner.nextInt();
            trainAndFly.collision(trainDistance, speedOfTrainA, speedOfTrainB, speedOfFly);
            System.out.println("#" + i + " " + trainAndFly.traveledDistance());
        }
    }
}

class TrainAndFly {
    private static double traveledDistance;
    public void collision(int trainDistance, int speedOfTrainA, int speedOfTrainB, int speedOfFly) {
        double time = (double)trainDistance / (speedOfTrainA + speedOfTrainB);
        TrainAndFly.traveledDistance = time * speedOfFly;
    }

    public double traveledDistance() {
        return TrainAndFly.traveledDistance;
    }
}

