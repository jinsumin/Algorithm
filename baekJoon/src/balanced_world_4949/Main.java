package balanced_world_4949;

/**
 * Created by Crab on 2020-03-16.
 */

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while (!(string = bufferedReader.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<Character>();
            boolean condition = true;

            for (int i = 0; i < string.length(); i++) {
                char aChar = string.charAt(i);
                if (aChar == '(' || aChar == '[') {
                    stack.push(aChar);
                }
                if (aChar == ')' || aChar == ']') {
                    if (stack.size() == 0) {
                        condition = false;
                        break;
                    }
                    if (aChar == ')') {
                        if (stack.peek() != '(') {
                            condition = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                    if (aChar == ']') {
                        if (stack.peek() != '[') {
                            condition = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
            if(!stack.isEmpty()) {
                System.out.println("no");
                continue;
            }
            if (condition) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}