import java.util.Scanner;

public class Main {
    private static final int[] DIRECTION_OF_ROW = {-1, 1, 0, 0};
    private static final int[] DIRECTION_OF_COL = {0, 0, -1, 1};
    private static final int VIRUS = 2;
    private static final int EMPTY = 0;
    private static final int WALL = 1;

    private static int[][] map;
    private static int[][] copiedMap;
    private static int maxCountOfSafetyAreas = 0;
    private static int chanceOfCanBuildWall = 3;
    private static int row, col;

    public static void main(String[] args) {
        inputData();
        System.out.println(solve());
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        copiedMap = new int[row][col];
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                map[i][j] = scanner.nextInt();
            }
        }
    }

    private static int solve() {
        buildWalls(chanceOfCanBuildWall, 0);
        return maxCountOfSafetyAreas;
    }

    private static void buildWalls(int chanceOfCanBuildWall, int startIndex){
        if(chanceOfCanBuildWall == 0) {
            copyMap();
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j ++){
                    if(copiedMap[i][j] == VIRUS) {
                        spreadVirus(i, j);
                    }
                }
            }
            maxCountOfSafetyAreas = Math.max(maxCountOfSafetyAreas, getSafetyAreas());
        }

        for(int i = startIndex + 1; i < row * col; i ++){
            int x = row / col;
            int y = row % col;
            if(map[x][y] == EMPTY) {
                map[x][y] = WALL;
                buildWalls(--chanceOfCanBuildWall, i);
                map[x][y] = EMPTY;
            }
        }
    }

    private static void spreadVirus(int dotOfRow, int dotOfCol) {
        for(int i = 0; i < 4; i ++) {
            int newDotOfRow = dotOfRow + DIRECTION_OF_ROW[i];
            int newDotOfCol = dotOfCol + DIRECTION_OF_COL[i];
            if(newDotOfRow >= 0 && newDotOfRow < row && newDotOfCol >= 0 && newDotOfCol < col) {
                if(copiedMap[newDotOfRow][newDotOfCol] == EMPTY) {
                    copiedMap[newDotOfRow][newDotOfCol] = VIRUS;
                    spreadVirus(newDotOfRow, newDotOfCol);
                }
            }
        }
    }

    private static void copyMap() {
        for(int i = 0; i < row; i ++){
            if (col >= 0) System.arraycopy(map[i], 0, copiedMap[i], 0, col);
        }
    }

    private static int getSafetyAreas() {
        int countOfSafetyAreas = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(copiedMap[i][j] == EMPTY) {countOfSafetyAreas ++;}
            }
        }
        return countOfSafetyAreas;
    }
}
