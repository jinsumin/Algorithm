package kakao_2020_internship.problem1;

/**
 * Created by Crab on 2020-05-09.
 */
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, hand));
    }
}

class Solution {
    private static final int[][] positions = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2}
    };

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Node leftFingerPosition = new Node(3, 0);
        Node rightFingerPosition = new Node(3, 2);
        for (int number : numbers) {
            Node numberPosition = new Node(positions[number][0], positions[number][1]);
            if (number == 1 || number == 4 || number == 7) {
                leftFingerPosition = numberPosition;
                answer.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                rightFingerPosition = numberPosition;
                answer.append("R");
            } else {
                if (manhattanDistance(leftFingerPosition, numberPosition)
                        < manhattanDistance(rightFingerPosition, numberPosition)) {
                    leftFingerPosition = numberPosition;
                    answer.append("L");
                } else if (manhattanDistance(leftFingerPosition, numberPosition)
                        > manhattanDistance(rightFingerPosition, numberPosition)) {
                    rightFingerPosition = numberPosition;
                    answer.append("R");
                } else {
                    if (hand.equals("left")) {
                        leftFingerPosition = numberPosition;
                        answer.append("L");
                    } else if (hand.equals("right")) {
                        rightFingerPosition = numberPosition;
                        answer.append("R");
                    }
                }
            }
        }
        return answer.toString();
    }

    private int manhattanDistance(Node fingerPosition, Node numberPosition) {
        return Math.abs(fingerPosition.r - numberPosition.r) + Math.abs(fingerPosition.c - numberPosition.c);
    }
}
