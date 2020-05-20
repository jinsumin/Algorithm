package cog_wheel_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-05-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CogWheel[] cogWheels = new CogWheel[4];
        for (int i = 0; i < 4; i++) {
            cogWheels[i] = new CogWheel(bufferedReader.readLine());
        }
        int numberOfRotation = Integer.parseInt(bufferedReader.readLine());
        RotateMethod[] rotateMethods = new RotateMethod[numberOfRotation];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < numberOfRotation; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int indexOfCogWheel = Integer.parseInt(stringTokenizer.nextToken());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            rotateMethods[i] = new RotateMethod(indexOfCogWheel, direction);
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(cogWheels, rotateMethods));
    }

    static class CogWheel {
        public LinkedList<Character> listOfCog = new LinkedList<>();

        public CogWheel(String cogWheel) {
            for (int i = 0; i < cogWheel.length(); i++) {
                listOfCog.add(cogWheel.charAt(i));
            }
        }
    }

    static class RotateMethod {
        int indexOfCogWheel, direction;

        public RotateMethod(int indexOfCogWheel, int direction) {
            this.indexOfCogWheel = indexOfCogWheel;
            this.direction = direction;
        }
    }
}

class Solution {
    private static final int RIGHT_COG_INDEX = 2;
    private static final int LEFT_COG_INDEX = 6;
    private static final int CLOCK_WISE = 1;
    private static final int COUNT_CLOCK_WISE = -1;
    private static final int RIGHT = 1;
    private static final int LEFT = 0;

    public int solution(Main.CogWheel[] cogWheels, Main.RotateMethod[] rotateMethods) {
        int score = 0;
        for (int i = 0; i < rotateMethods.length; i++) {
            int[] rotateChecked = new int[4];
            rotateCogWheels(cogWheels, rotateChecked, rotateMethods[i], RIGHT);
            rotateCogWheels(cogWheels, rotateChecked, rotateMethods[i], LEFT);
            initCogWheels(cogWheels, rotateChecked);
        }
        for (int i = 0; i < cogWheels.length; i++) {
            if (cogWheels[i].listOfCog.getFirst() == '1') {
                score += Math.pow(2, i);
            }
        }
        return score;
    }

    private void rotateCogWheels(Main.CogWheel[] cogWheels, int[] rotateChecked, Main.RotateMethod rotateMethod, int side) {
        //System.out.println("rotateMethod.indexOfCogWheel : " + rotateMethod.indexOfCogWheel);
        if (rotateMethod.indexOfCogWheel - 1 < 0 || rotateMethod.indexOfCogWheel - 1 > 3) {
            return;
        }
        if (side == RIGHT) {
            rotateChecked[rotateMethod.indexOfCogWheel - 1] = rotateMethod.direction;
            if (rotateMethod.indexOfCogWheel - 1 <= 2) {
                if (cogWheels[rotateMethod.indexOfCogWheel - 1].listOfCog.get(RIGHT_COG_INDEX) != cogWheels[rotateMethod.indexOfCogWheel].listOfCog.get(LEFT_COG_INDEX)) {
                    rotateChecked[rotateMethod.indexOfCogWheel] = rotateMethod.direction * -1;
                    rotateCogWheels(cogWheels, rotateChecked, new Main.RotateMethod(rotateMethod.indexOfCogWheel + 1, rotateMethod.direction * -1), RIGHT);
                }
            }
        } else if (side == LEFT) {
            rotateChecked[rotateMethod.indexOfCogWheel - 1] = rotateMethod.direction;
            if (rotateMethod.indexOfCogWheel - 1 >= 1) {
                if (cogWheels[rotateMethod.indexOfCogWheel - 1].listOfCog.get(LEFT_COG_INDEX) != cogWheels[rotateMethod.indexOfCogWheel - 2].listOfCog.get(RIGHT_COG_INDEX)) {
                    rotateChecked[rotateMethod.indexOfCogWheel - 2] = rotateMethod.direction * -1;
                    rotateCogWheels(cogWheels, rotateChecked, new Main.RotateMethod(rotateMethod.indexOfCogWheel - 1, rotateMethod.direction * -1), LEFT);
                }
            }
        }
    }

    private void initCogWheels(Main.CogWheel[] cogWheels, int[] rotateChecked) {
        for (int i = 0; i < 4; i++) {
            if (rotateChecked[i] == CLOCK_WISE) {
                char cog = cogWheels[i].listOfCog.pollLast();
                cogWheels[i].listOfCog.offerFirst(cog);
            } else if (rotateChecked[i] == COUNT_CLOCK_WISE) {
                char cog = cogWheels[i].listOfCog.pollFirst();
                cogWheels[i].listOfCog.offerLast(cog);
            }
        }
    }
}
