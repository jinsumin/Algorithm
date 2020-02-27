package Section4;

import java.util.Scanner;
import java.util.Stack;

public class Game {
    public static void main(String args[]){
        int[][] maze = {
                {9, 9, 9, 9, 9, 9, 9, 9},
                {9, 0, 0, 0, 0, 1, 0, 9},
                {9, 0, 0, 0, 0, 1, 0, 9},
                {9, 1, 0, 1, 1, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 1, 1, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 9},
                {9, 9, 9, 9, 9, 9, 9, 9}
        };
        Stack<Offset> stack = new Stack<Offset>();
        int x = 1;
        int y = 1;
        int len = 0;
        while(len < 31){
            if(maze[x][y] == 0){
                maze[x][y] = 2;
                stack.push(new Offset(x, y));
                len++;
            }
            if(maze[x-1][y] == 0)
                x--;
            else if(maze[x][y+1] == 0)
                y++;
            else if(maze[x+1][y] == 0)
                x++;
            else if(maze[x][y-1] == 0)
                y--;
            else if(maze[maze.length-1][maze[0].length-2] != 0)
                break;
            else if(maze[x-1][y] == 2){
                maze[x][y] = 3;
                x = stack.peek().x;
                y = stack.peek().y;
                stack.pop();
                len--;
            }else if(maze[x][y+1] == 2){
                maze[x][y] = 3;
                x = stack.peek().x;
                y = stack.peek().y;
                stack.pop();
                len--;
            }else if(maze[x+1][y] == 2){
                maze[x][y] = 3;
                x = stack.peek().x;
                y = stack.peek().y;
                stack.pop();
                len--;
            }else if(maze[x][y-1] == 2){
                maze[x][y] = 3;
                x = stack.peek().x;
                y = stack.peek().y;
                stack.pop();
                len--;
            }
        }
        for (int[] ints : maze) {
            for (int j = 0; j < maze.length; j++)
                System.out.print(ints[j] + "\t");
            System.out.println();
        }
    }
}

class Offset{
    public int x, y;
    public Offset(int x, int y){
        this.x = x;
        this.y = y;
    }
}
