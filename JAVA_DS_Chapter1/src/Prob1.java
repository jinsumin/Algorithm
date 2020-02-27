import java.util.Scanner;

public class Prob1 {

    public static void main(String[] args){

        int N;  // 우정이가 원래 갖고 있던 색종이의 개수
        int k;  // 우정이가 원래 갖고 있던 색종이 색깔의 종류수

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트 케이스 횟수
        int[] res = new int[T]; // 각 테스트 케이스 마다 저장할 결과 값

        for(int i = 0; i < T; i ++){
            N = sc.nextInt();
            k = sc.nextInt();
            int[] data = new int[N];
            for(int j = 0; j < N; j ++){
                data[j] = sc.nextInt();
            }
            res[i] = solution(data, i);
        }
        sc.close();

        for(int i = 1; i <= T; i ++){
            System.out.println("#" + i + " " + res[i-1]);
        }
    }

    private static int solution(int[] data, int k){
        data[0] = 1;    // 처음 색종이 색
        data[data.length - 1] = k;  // 마지막 색종이 색
        int maxSequence = 1;    // 색종이 연속 배열 수 초기화

        for(int i = 1; i <= k; i ++) {   // 색종이 색상별로 체크
            int sequence = 0;    // i 색깔 색종이의 연속 나열 갯수 초기화
            int index = find(data, i);  // i 색깔 색종이의 첫 시작 인덱스
            int jumpCheck = 0;
            for (int j = index; j < data.length; j++) {
                if (data[j] != 0 && data[j] != i) {
                    jumpCheck = data[j];    // 색종이가 바뀌는 종류 번호 저장
                    break;  // sequence 값 증가시키지 않고 for 문 종료
                }
                sequence++;   // 그 외의 경우(같은 색상이거나 색종이 색이 지워진경우) i 색종이의 연속 배열 횟수 증가
            }
            for (int j = i + 1; j < jumpCheck; j++) {
                sequence--;   // 색종이 종류가 2 이상 차이날 경우 차이 나는 만큼 감소 : 중간에 다른 색종이가 낄 자리필요
            }
            if (sequence > maxSequence) {
                maxSequence = sequence;    // i 색상 색종이의 연속 나열 갯수가 이전보다 큰 경우 초기화
            }
        }
        return maxSequence;
    }

    private static int find(int[] data, int k) {
        int index = k - 1;
        if(k == 1) return 0;
        for(int i = data.length - 1; i > 0; i --){
            for(int j = 1; j < k; j ++){
                if(data[i] == (k - j)){
                    index = (i + j);
                    return index;
                }
            }
        }
        return index;
    }
}
