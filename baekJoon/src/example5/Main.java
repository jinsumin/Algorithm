package example5;

/**
 * Created by REMI on 2020-03-03.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution{
    private int n = 0;
    public void solution() {
        func();
        System.out.println(n);
    }

    private void func() {
        n ++;
    }
}