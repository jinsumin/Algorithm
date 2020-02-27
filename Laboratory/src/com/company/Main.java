//package com.company;
//
//import java.util.Scanner;
//
//public class Laboratory {
//    private static final int[] DIRECTION_OF_ROW = {-1, 1, 0, 0};
//    private static final int[] DIRECTION_OF_COL = {0, 0, -1, 1};
//    private static final int VIRUS = 2;
//    private static final int EMPTY = 0;
//    private static final int WALL = 1;
//    private static final int BOUNDARY = 0;
//
//    private int maxCountOfSafetyAreas;
//    private int chanceOfCanBuildWalls;
//    private int[][] map;
//    private int[][] copiedMap;
//    private int row, col;
//
//    public int getMaxCountOfSafetyAreas() {
//        return maxCountOfSafetyAreas;
//    }
//
//    public void setMaxCountOfSafetyAreas(int maxCountOfSafetyAreas) {
//        this.maxCountOfSafetyAreas = maxCountOfSafetyAreas;
//    }
//
//    public int getChanceOfCanBuildWalls() {
//        return chanceOfCanBuildWalls;
//    }
//
//    public void setChanceOfCanBuildWalls(int chanceOfCanBuildWalls) {
//        this.chanceOfCanBuildWalls = chanceOfCanBuildWalls;
//    }
//
//    public int getRow() {
//        return row;
//    }
//
//    public void setRow(int row) {
//        this.row = row;
//    }
//
//    public int getCol() {
//        return col;
//    }
//
//    public void setCol(int col) {
//        this.col = col;
//    }
//
//    public int[][] getMap() {
//        return map;
//    }
//
//    public void setMap(int row, int col) {
//        this.map = new int[row][col];
//    }
//
//    public int[][] getCopiedMap() {
//        return copiedMap;
//    }
//
//    public void setCopiedMap() {
//        this.copiedMap = new int[getRow()][getCol()];
//    }
//
//    public Laboratory() {
//        this.chanceOfCanBuildWalls = 3;
//        this.maxCountOfSafetyAreas = 0;
//    }
//
//    public static void main(String[] args) {
//        Laboratory lab = new Laboratory();
//        lab.inputData();
//        lab.buildWalls(0);
//        lab.printResult();
//    }
//
//    private void inputData() {
//        Scanner scanner = new Scanner(System.in);
//        setRow(scanner.nextInt());
//        setCol(scanner.nextInt());
//        setMap(getRow(), getCol());
//        setCopiedMap();
//        for (int i = 0; i < getRow(); i++) {
//            for (int j = 0; j < getCol(); j++) {
//                getMap()[i][j] = scanner.nextInt();
//            }
//        }
//    }
//
//    private void buildWalls(int startIndex) {
//        if (getChanceOfCanBuildWalls() == EMPTY) {
//            copyMap();
//            for (int i = 0; i < getRow(); i++) {
//                for (int j = 0; j < getCol(); j++) {
//                    if (getMap()[i][j] == VIRUS) {
//                        spreadVirus(i, j);
//                    }
//                }
//            }
//            setMaxCountOfSafetyAreas(Math.max(getMaxCountOfSafetyAreas(), getSafetyAreas()));
//            return;
//        }
//
//        for (int i = 0; i < getRow() * getCol(); i++) {
//            int indexOfRow = i / getCol();
//            int indexOfCol = i % getCol();
//            if (getMap()[indexOfRow][indexOfCol] == EMPTY) {
//                getMap()[indexOfRow][indexOfCol] = WALL;
//                setChanceOfCanBuildWalls(getChanceOfCanBuildWalls() - 1);
//                buildWalls(i + 1);
//                setChanceOfCanBuildWalls(getChanceOfCanBuildWalls() + 1);
//                getMap()[indexOfRow][indexOfCol] = EMPTY;
//            }
//        }
//    }
//
//    private void spreadVirus(int dotOfRow, int dotOfCol) {
//        for (int i = 0; i < 4; i++) {
//            int newDotOfRow = dotOfRow + DIRECTION_OF_ROW[i];
//            int newDotOfCol = dotOfCol + DIRECTION_OF_COL[i];
//            boolean outOfIndex = !(newDotOfRow >= BOUNDARY && newDotOfRow < getRow()
//                    && newDotOfCol >= BOUNDARY && newDotOfCol < getCol());
//            if (!outOfIndex) {
//                if (getCopiedMap()[newDotOfRow][newDotOfCol] == EMPTY) {
//                    getCopiedMap()[newDotOfRow][newDotOfCol] = VIRUS;
//                    spreadVirus(newDotOfRow, newDotOfCol);
//                }
//            }
//        }
//    }
//
//    private void copyMap() {
//        for (int i = 0; i < getRow(); i++) {
//            if (getCol() >= 0) System.arraycopy(getMap()[i], 0, getCopiedMap()[i], 0, col);
//        }
//    }
//
//    private int getSafetyAreas() {
//        int countOfSafetyAreas = 0;
//        for (int i = 0; i < getRow(); i++) {
//            for (int j = 0; j < getCol(); j++) {
//                if (getCopiedMap()[i][j] == EMPTY) {
//                    countOfSafetyAreas++;
//                }
//            }
//        }
//        return countOfSafetyAreas;
//    }
//
//    private void printResult() {
//        System.out.println(getMaxCountOfSafetyAreas());
//    }
//}


package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int row = scanner.nextInt();
        final int col = scanner.nextInt();

        final Laboratory lab = new Laboratory(row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int kindOfWall = scanner.nextInt();
                lab.addWall(i, j, kindOfWall);
            }
        }

        lab.buildWall();
        System.out.println(lab.getMaxCountOfSafetyAreas());
    }
}

enum KindOfWall {
    VIRUS(2), EMPTY(0), WALL(1);
    private final int num;

    KindOfWall(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static KindOfWall of(int num) {
        return Arrays.stream(KindOfWall.values())
                .filter(kindOfWall -> kindOfWall.getNum() == num)
                .findAny()
                .orElse(EMPTY);
    }
}

class Wall {
    private KindOfWall kindOfWall;

    Wall(KindOfWall kindOfWall) {
        this.kindOfWall = kindOfWall;
    }

//    public KindOfWall getKindOfWall() {
//        return kindOfWall;
//    }

    public void updateKindOfWall(KindOfWall kindOfWall) {
        this.kindOfWall = kindOfWall;
    }

    public boolean isEmpty() {
        return kindOfWall == KindOfWall.EMPTY;
    }

    public boolean hasVirus() {
        return kindOfWall == KindOfWall.VIRUS;
    }

//    public boolean hasWall() {
//        return kindOfWall == KindOfWall.WALL;
//    }
}

class Laboratory {
    private static final int[] DIRECTION_OF_ROW = { -1, 1, 0, 0 };
    private static final int[] DIRECTION_OF_COL = { 0, 0, -1, 1 };
    private static final int BOUNDARY = 0;

    private int maxCountOfSafetyAreas;
    private int chanceOfCanBuildWalls;
    private final Wall[][] map;
    private final Wall[][] copiedMap;
    private final int row;
    private final int col;

    public void setMaxCountOfSafetyAreas(int maxCountOfSafetyAreas) {
        this.maxCountOfSafetyAreas = maxCountOfSafetyAreas;
    }

    public int getMaxCountOfSafetyAreas() {
        return maxCountOfSafetyAreas;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Laboratory(int row, int col) {
        this.row = row;
        this.col = col;
        map = new Wall[row][col];
        copiedMap = new Wall[row][col];
        chanceOfCanBuildWalls = 3;
        maxCountOfSafetyAreas = 0;
    }

    public void addWall(int row, int col, int kindOfWall) {
        map[row][col] = new Wall(KindOfWall.of(kindOfWall));
    }

    public void buildWall() {
        if (KindOfWall.of(chanceOfCanBuildWalls) == KindOfWall.EMPTY) {
            copyMap();
            for (int i = 0; i < getRow(); i++) {
                for (int j = 0; j < getCol(); j++) {
                    if (map[i][j].hasVirus()) {
                        spreadVirus(i, j);
                    }
                }
            }
            setMaxCountOfSafetyAreas(Math.max(getMaxCountOfSafetyAreas(), getSafetyAreas()));
            return;
        }

        for (int i = 0; i < row * col; i++) {
            final int indexOfRow = i / col;
            final int indexOfCol = i % col;
            if (map[indexOfRow][indexOfCol].isEmpty()) {
                map[indexOfRow][indexOfCol].updateKindOfWall(KindOfWall.WALL);
                chanceOfCanBuildWalls--;
                buildWall();
                chanceOfCanBuildWalls++;
                map[indexOfRow][indexOfCol].updateKindOfWall(KindOfWall.EMPTY);
            }
        }
    }

    public void spreadVirus(int dotOfRow, int dotOfCol) {
        for (int i = 0; i < 4; i++) {
            final int newDotOfRow = dotOfRow + DIRECTION_OF_ROW[i];
            final int newDotOfCol = dotOfCol + DIRECTION_OF_COL[i];
            final boolean outOfIndex = !(newDotOfRow >= BOUNDARY && newDotOfRow < getRow()
                    && newDotOfCol >= BOUNDARY && newDotOfCol < getCol());
            if (outOfIndex) {
                continue;
            }

            if (copiedMap[newDotOfRow][newDotOfCol].isEmpty()) {
                copiedMap[newDotOfRow][newDotOfCol].updateKindOfWall(KindOfWall.VIRUS);
                spreadVirus(newDotOfRow, newDotOfCol);
            }
        }
    }

    private void copyMap() {
        for (int i = 0; i < getRow(); i++) {
            if (getCol() >= 0) {
                System.arraycopy(map[i], 0, copiedMap[i], 0, col);
            }
        }
    }

    private int getSafetyAreas() {
        int countOfSafetyAreas = 0;
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCol(); j++) {
                if (copiedMap[i][j].isEmpty()) {
                    countOfSafetyAreas++;
                }
            }
        }
        return countOfSafetyAreas;
    }

}
