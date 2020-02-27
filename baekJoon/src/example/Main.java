package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfPeople = scanner.nextInt();

        final BigBody[] bigBody = new BigBody[numberOfPeople];
        final BigBody[] copiedBody = new BigBody[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            final int weight = scanner.nextInt();
            final int height = scanner.nextInt();
            bigBody[i] = new BigBody(weight, height);
            copiedBody[i] = new BigBody(weight, height);
        }
        setRankOfBigBody(bigBody);
        printRankOfBigBody(bigBody);
    }

//    private static void sortOfBigBody(example.BigBody[] bigBody) {
//        Arrays.sort(bigBody, (o1, o2) -> {
//            if(o1.getWeight() > o2.getWeight() && o1.getHeight() > o2.getHeight()) {
//                return -1;
//            }else if(o1.getWeight() < o2.getWeight() && o1.getHeight() < o2.getHeight()){
//                return 1;
//            }
//            return 0;
//        });
//    }
//
//    private static void printListOfBigBody(example.BigBody[] bigBody) {
//        for (example.BigBody body : bigBody) {
//            System.out.println(body.getWeight() + " " + body.getHeight());
//        }
//    }

    private static void setRankOfBigBody(BigBody[] bigBody) {
        for (BigBody body : bigBody) {
            body.setRank(body.getRank() + 1);
            for (BigBody value : bigBody) {
                if (body.getWeight() > value.getWeight() && body.getHeight() > value.getHeight()) {
                    value.setRank(value.getRank() + 1);
                }
            }
        }
    }

    private static void printRankOfBigBody(BigBody[] bigBody) {
        for (BigBody body : bigBody){
            System.out.println(body.getRank());
        }
    }

}

class BigBody {
    private static final int UN_RANKED = 0;
    private final int weight;
    private final int height;
    private int rank;

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    BigBody(int weight, int height) {
        this.weight = weight;
        this.height = height;
        setRank(UN_RANKED);
    }
}
