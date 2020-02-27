package Section1;

public class Code01 {
    public static void main(String []args){

        int[] grades;
        grades = new int[10];

        grades[0] = 1;
        grades[1] = 2;
        grades[2] = 3;
        grades[3] = 4;
        grades[4] = 5;

        for(int i = 0; i < grades.length; i++){
            System.out.println(grades[i]);
        }

    }
}
