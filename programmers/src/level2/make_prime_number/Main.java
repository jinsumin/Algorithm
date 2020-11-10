package level2.make_prime_number;

/**
 * Created by Crab on 2020-11-10.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(nums));
    }
}

class Solution {
    private static int countOfPrimeNumber = 0;

    public int solution(int[] nums) {
        boolean[] selected = new boolean[nums.length];
        combination(nums, selected, 0, nums.length, 3);
        return countOfPrimeNumber;
    }

    private void combination(int[] nums, boolean[] selected, int start, int n, int r) {
        if (r == 0) {
            if (isPrimeNumber(getSumOfNumbers(nums, selected))) {
                countOfPrimeNumber++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            selected[i] = true;
            combination(nums, selected, i + 1, n, r - 1);
            selected[i] = false;
        }
    }

    private boolean isPrimeNumber(int sumOfNumbers) {
        for (int i = 2; i * i <= sumOfNumbers; i++) {
            if (sumOfNumbers % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getSumOfNumbers(int[] nums, boolean[] selected) {
        int sumOfSelected = 0;
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                sumOfSelected += nums[i];
            }
        }
        return sumOfSelected;
    }
}
