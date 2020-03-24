package queue2_18258;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<Integer>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            String command = str[0];
            int num = 0;
            if (str.length > 1)
                num = Integer.parseInt(str[1]);

            switch (command) {
                case "push":
                    dq.add(num);
                    break;
                case "front":
                    System.out.print((dq.isEmpty() ? -1 : dq.getFirst()) + "\n");
                    break;
                case "back":
                    System.out.print((dq.isEmpty() ? -1 : dq.getLast()) + "\n");
                    break;
                case "size":
                    System.out.print((dq.size()) + "\n");
                    break;
                case "empty":
                    System.out.print((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "pop":
                    System.out.print((dq.isEmpty() ? -1 : dq.poll()) + "\n");
                    break;
            }
        }
    }
}