package cubing_5373;

import java.util.Scanner;

/**
 * Created by REMI on 2020-02-03.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            String str = scanner.next();
            String[] rotateType = str.split(" ");
            Cubing cube = new Cubing();
            cube.cubing(rotateType);
        }
    }
}

class Cubing {
    private char[][] cube;

    public Cubing() {
        cube = new char[][]{
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'o', 'o', 'o', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'o', 'o', 'o', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'o', 'o', 'o', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'y', 'y', 'y', 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y'},
                {'y', 'y', 'y', 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y'},
                {'y', 'y', 'y', 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'r', 'r', 'r', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'r', 'r', 'r', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'r', 'r', 'r', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'},
                {'z', 'z', 'z', 'z', 'z', 'z', 'y', 'y', 'y', 'z', 'z', 'z', 'z', 'z', 'z'}
        };
    }

    public void cubing(String[] rotateType) {
        for (String s : rotateType) {
            char side = s.charAt(0);
            char rotateDirection = s.charAt(1);
            if(rotateDirection == '+') {
                rotate(side);
            }else if(rotateDirection == '-'){
                rotate(side);
                rotate(side);
                rotate(side);
            }
        }
        printUpSide();
    }

    private void rotate(char side) {
        if (side == 'B') {
            char temp1 = cube[5][6];
            char temp2 = cube[5][7];
            char temp3 = cube[5][8];

            cube[5][6] = cube[5][8];
            cube[5][7] = cube[4][8];
            cube[5][8] = cube[3][8];

            cube[5][8] = cube[3][8];
            cube[4][8] = cube[3][7];
            cube[3][8] = cube[3][6];

            cube[3][6] = temp1;
            cube[4][6] = temp2;
            cube[5][6] = temp3;

            for (int i = 0; i < 12; i++) {
                cube[6][i] = cube[6][i + 3];
            }
            cube[6][12] = cube[6][0];
            cube[6][13] = cube[6][1];
            cube[6][14] = cube[6][2];

            cube[2][8] = cube[6][0];
            cube[2][7] = cube[6][1];
            cube[2][6] = cube[6][2];

            cube[14][8] = cube[6][0];
            cube[14][7] = cube[6][1];
            cube[14][6] = cube[6][2];
        } else if (side == 'F') {
            char temp1 = cube[9][8];
            char temp2 = cube[9][7];
            char temp3 = cube[9][6];

            cube[9][8] = cube[9][6];
            cube[9][7] = cube[10][6];
            cube[9][6] = cube[11][6];

            cube[9][6] = cube[11][6];
            cube[10][6] = cube[11][7];
            cube[11][6] = cube[11][8];

            cube[11][6] = cube[11][8];
            cube[11][7] = cube[10][8];
            cube[11][8] = cube[9][8];

            cube[11][8] = temp1;
            cube[10][8] = temp2;
            cube[9][8] = temp3;

            for (int i = 11; i >= 0; i--) {
                cube[8][i + 3] = cube[8][i];
            }
            cube[8][0] = cube[8][12];
            cube[8][1] = cube[8][13];
            cube[8][2] = cube[8][14];

            cube[2][8] = cube[8][0];
            cube[2][7] = cube[8][1];
            cube[2][6] = cube[8][2];

            cube[12][8] = cube[8][0];
            cube[12][7] = cube[8][1];
            cube[12][6] = cube[8][2];
        } else if (side == 'L') {
            char temp1 = cube[8][5];
            char temp2 = cube[7][5];
            char temp3 = cube[6][5];

            cube[8][5] = cube[6][5];
            cube[7][5] = cube[6][4];
            cube[6][5] = cube[6][3];

            cube[6][5] = cube[6][3];
            cube[6][4] = cube[7][3];
            cube[6][3] = cube[8][3];

            cube[6][3] = cube[8][3];
            cube[7][3] = cube[8][4];
            cube[8][3] = cube[8][5];

            cube[8][3] = temp1;
            cube[8][4] = temp2;
            cube[8][5] = temp3;

            for (int i = 11; i >= 0; i--) {
                cube[i + 3][6] = cube[i][6];
            }
            cube[0][6] = cube[12][6];
            cube[1][6] = cube[13][6];
            cube[2][6] = cube[14][6];

            cube[6][2] = cube[2][6];
            cube[7][2] = cube[1][6];
            cube[8][2] = cube[0][6];

            cube[6][14] = cube[6][2];
            cube[7][14] = cube[7][2];
            cube[8][14] = cube[8][2];
        } else if (side == 'R') {
            char temp1 = cube[6][9];
            char temp2 = cube[7][9];
            char temp3 = cube[8][9];

            cube[6][9] = cube[8][9];
            cube[7][9] = cube[8][10];
            cube[8][9] = cube[8][11];

            cube[8][9] = cube[8][11];
            cube[8][10] = cube[7][11];
            cube[8][11] = cube[6][11];

            cube[8][11] = cube[6][11];
            cube[7][11] = cube[6][10];
            cube[6][11] = cube[6][9];

            cube[6][11] = temp1;
            cube[6][10] = temp2;
            cube[6][9] = temp3;

            for (int i = 0; i < 12; i++) {
                cube[i][8] = cube[i + 3][8];
            }
            cube[12][8] = cube[0][8];
            cube[13][8] = cube[1][8];
            cube[14][8] = cube[2][8];

            cube[6][0] = cube[2][8];
            cube[7][0] = cube[1][8];
            cube[8][0] = cube[0][8];

            cube[6][12] = cube[2][8];
            cube[7][12] = cube[1][8];
            cube[8][12] = cube[0][8];
        } else if (side == 'U') {
            char temp1 = cube[6][8];
            char temp2 = cube[6][7];
            char temp3 = cube[6][6];

            cube[6][8] = cube[6][6];
            cube[6][7] = cube[7][6];
            cube[6][6] = cube[8][6];

            cube[6][6] = cube[8][6];
            cube[7][6] = cube[8][7];
            cube[8][6] = cube[8][8];

            cube[8][6] = cube[8][8];
            cube[8][7] = cube[7][8];
            cube[8][8] = cube[6][8];

            cube[8][8] = temp1;
            cube[7][8] = temp2;
            cube[6][8] = temp3;

            char temp4 = cube[5][8];
            char temp5 = cube[5][7];
            char temp6 = cube[5][6];

            cube[5][8] = cube[6][5];
            cube[5][7] = cube[7][5];
            cube[5][6] = cube[8][5];

            cube[6][5] = cube[9][6];
            cube[7][5] = cube[9][7];
            cube[8][5] = cube[9][8];

            cube[9][6] = cube[8][9];
            cube[9][7] = cube[7][9];
            cube[9][8] = cube[6][9];

            cube[8][9] = temp4;
            cube[7][9] = temp5;
            cube[6][9] = temp6;
        } else if (side == 'D') {
            char temp1 = cube[3][6];
            char temp2 = cube[3][7];
            char temp3 = cube[3][8];

            cube[3][6] = cube[6][11];
            cube[3][7] = cube[7][11];
            cube[3][8] = cube[8][11];

            cube[6][11] = cube[11][8];
            cube[7][11] = cube[11][7];
            cube[8][11] = cube[11][6];

            cube[11][8] = cube[8][3];
            cube[11][7] = cube[7][3];
            cube[11][6] = cube[6][3];

            cube[8][3] = temp1;
            cube[7][3] = temp2;
            cube[6][3] = temp3;

            char temp4 = cube[6][0];
            char temp5 = cube[6][1];
            char temp6 = cube[6][2];

            cube[6][0] = cube[6][2];
            cube[6][1] = cube[7][2];
            cube[6][2] = cube[8][2];

            cube[6][2] = cube[8][2];
            cube[7][2] = cube[8][1];
            cube[8][2] = cube[8][0];

            cube[8][2] = cube[8][0];
            cube[8][1] = cube[7][0];
            cube[8][0] = cube[6][0];

            cube[8][0] = temp4;
            cube[7][0] = temp5;
            cube[6][0] = temp6;

            cube[6][12] = cube[6][0];
            cube[6][13] = cube[6][1];
            cube[6][14] = cube[6][2];
            cube[7][12] = cube[7][0];
            cube[7][13] = cube[7][1];
            cube[7][14] = cube[7][2];
            cube[8][12] = cube[8][0];
            cube[8][13] = cube[8][1];
            cube[8][14] = cube[8][2];

            cube[2][8] = cube[6][0];
            cube[2][7] = cube[6][1];
            cube[2][6] = cube[6][2];
            cube[1][8] = cube[7][0];
            cube[1][7] = cube[7][1];
            cube[1][6] = cube[7][2];
            cube[0][8] = cube[8][0];
            cube[0][7] = cube[8][1];
            cube[0][6] = cube[8][2];

            cube[14][8] = cube[6][0];
            cube[14][7] = cube[6][1];
            cube[14][6] = cube[6][2];
            cube[13][8] = cube[7][0];
            cube[13][7] = cube[7][1];
            cube[13][6] = cube[7][2];
            cube[14][8] = cube[8][0];
            cube[14][7] = cube[8][1];
            cube[14][6] = cube[8][2];
        }
    }

    private void printUpSide() {
        System.out.println(cube[6][6] + cube[6][7] + cube[6][8]);
        System.out.println(cube[7][6] + cube[7][7] + cube[7][8]);
        System.out.println(cube[8][6] + cube[8][7] + cube[8][8]);
    }
}
