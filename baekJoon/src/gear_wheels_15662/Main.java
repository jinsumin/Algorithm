package gear_wheels_15662;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by REMI on 2020-02-12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGearWheel = scanner.nextInt();
        int[][] gearWheels = new int[numberOfGearWheel][8];
        for (int i = 0; i < numberOfGearWheel; i++) {
            for (int j = 0; j < 8; j++) {
                gearWheels[i][j] = scanner.nextInt();
            }
        }
        int numberOfRotations = scanner.nextInt();
        int[][] rotateWheels = new int[numberOfRotations][2];
        for (int i = 0; i < numberOfRotations; i++) {
            rotateWheels[i][0] = scanner.nextInt();
            rotateWheels[i][1] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(gearWheels, rotateWheels));
    }
}

class Solution {
    public int solution(int[][] gearWheels, int[][] rotateWheels) {
        Deque<Integer>[] deque = new Deque[gearWheels.length];
        for (int i = 0; i < gearWheels.length; i++) {
            deque[i] = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                deque[i].add(gearWheels[i][j]);
            }
        }
        for (int i = 0; i < rotateWheels.length; i++) {
            int rotateWheel = rotateWheels[i][0];
            int rotateDirection = rotateWheels[i][1];
            rotateGearWheels(gearWheels, deque, rotateWheel, rotateDirection);
        }
        return countNorthGearWithN(deque);
    }

    private void rotateGearWheels(int[][] gearWheels, Deque<Integer>[] deque, int rotateWheel, int rotateDirection) {
        int[][] checkLinkedWheels = new int[deque.length][2];
        checkLinkedWheels[rotateWheel - 1][0] = 1;
        checkLinkedWheels[rotateWheel - 1][1] = rotateDirection;

        for(int i = 0; i < 8; i ++) {
            if(gearWheels[(rotateWheel - 1 + i) % 8][2] != gearWheels[(rotateWheel + i) % 8][6]) {
                checkLinkedWheels[(rotateWheel - 1 + i) % 8][0] = 1;
                checkLinkedWheels[(rotateWheel - 1 + i) % 8][1] = rotateDirection;
                checkLinkedWheels[(rotateWheel + i) % 8][0] = 1;
                checkLinkedWheels[(rotateWheel + i) % 8][1] = rotateDirection * (-1);
            } else {
                break;
            }
        }
        int leftIndex = rotateWheel;
        int rightIndex = rotateWheel - 1;
        for(int i = 0; i < 8; i ++) {
            leftIndex --;
            rightIndex --;
            if(leftIndex == -1) {
                leftIndex = 7;
            }
            if(rightIndex == -1) {
                rightIndex = 7;
            }
            if(gearWheels[(leftIndex)][6] != gearWheels[(rightIndex)][2]) {
                checkLinkedWheels[(leftIndex)][0] = 1;
                checkLinkedWheels[(leftIndex)][1] = rotateDirection;
                checkLinkedWheels[(rightIndex)][0] = 1;
                checkLinkedWheels[(rightIndex)][1] = rotateDirection * (-1);
            } else {
                break;
            }
        }
        for(int i = 0; i < gearWheels.length; i ++) {
            if(checkLinkedWheels[i][0] == 1) {
                rotateGearWheel(deque, i, checkLinkedWheels[i][1]);
            }
        }
    }

    private void rotateGearWheel(Deque<Integer>[] deque, int wheelNumber, int rotateDirection) {
        if(rotateDirection == 1) {
            int temp = deque[wheelNumber].pollLast();
            deque[wheelNumber].offerFirst(temp);
        } else {
            int temp = deque[wheelNumber].pollFirst();
            deque[wheelNumber].offerLast(temp);
        }
    }

    private int countNorthGearWithN(Deque<Integer>[] deque) {
        int count = 0;
        for(int i = 0; i < deque.length; i ++) {
            if(deque[i].peekFirst() == 1) {
                count ++;
            }
        }
        return count;
    }
}
