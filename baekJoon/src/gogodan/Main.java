package gogodan;

/**
 * Created by Crab on 2020-03-20.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int N;
    static boolean condition;
    static boolean secondCondition;

    static Stack<Character> stack;
    static Queue<Character> queue;

    static Stack<Character> secondStack;
    static Queue<Character> secondQueue;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        String inputString;

        for (int i = 1; i <= N; i++) {
            inputString = bufferedReader.readLine();
            stack = new Stack<Character>();
            queue = new LinkedList<Character>();
            condition = true;
            secondCondition = true;
            for (int j = 0; j < inputString.length(); j++) {
                char aChar = inputString.charAt(j);
                stack.push(aChar);
                queue.offer(aChar);
            }

            while (!(stack.isEmpty() || queue.isEmpty())) {

                if (stack.peek() == queue.peek()) {
                    stack.pop();
                    queue.poll();
                } else if (stack.peek() != queue.peek()) {
                    condition = false;
                    char StackChar = stack.peek();
                    char QueueChar = queue.peek();
                    stack.pop();
                    queue.poll();

                    if (StackChar != queue.peek() || QueueChar != stack.peek()) {
                        secondStack = new Stack<Character>();
                        secondQueue = new LinkedList<Character>();
                        for (int k = 0; k < queue.size(); k++){
                            secondStack.push(stack.pop());
                            secondQueue.offer(queue.poll());
                        }
                        while (!(secondQueue.isEmpty() || queue.isEmpty())){
                            if (secondStack.peek() == secondQueue.peek()) {
                                secondStack.pop();
                                secondQueue.poll();
                            }
                            else {
                                secondCondition = false;
                                bufferedWriter.write("2\n");
                                break;
                            }
                        }
                        if (secondCondition){
                            bufferedWriter.write("1\n");
                            break;
                        }
//                        bufferedWriter.write("2\n");
//                        condition = false;
//                        break;
                    }
                    // 윗 부분에서 어떠캐 해야될까ㅏㅏㅏㅏㅏㅏ
//                        반례 : abbaabbb
//                        정답 = 2
//                        출력 = 1
                } else {
                    bufferedWriter.write("2\n");
                    break;
                }
            }
            if (condition && secondCondition) {
                bufferedWriter.write("0\n");
            }
        }
        bufferedWriter.flush();
    }
}