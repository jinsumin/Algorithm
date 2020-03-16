package stack_sequence_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Crab on 2020-03-16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Solution solution = new Solution();
        solution.solution(array);
    }
}

class Solution {
    public void solution(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Character> queue = new LinkedList<>();
        int index = 0;
        for(int number = 1; number <= array.length; number ++) {
            stack.push(number);
            queue.offer('+');
            while(!stack.isEmpty()) {
                if(array[index] == stack.peek()) {
                    stack.pop();
                    queue.offer('-');
                    index ++;
                } else {
                    break;
                }
            }
        }
        if(index == array.length) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                System.out.println(queue.poll());
            }
        } else {
            System.out.println("NO");
        }
    }
}
