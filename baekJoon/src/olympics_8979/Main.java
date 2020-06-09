package olympics_8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-06-08.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfNations = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        Medal[] medals = new Medal[numberOfNations];
        for (int i = 0; i < numberOfNations; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int index = Integer.parseInt(stringTokenizer.nextToken());
            int gold = Integer.parseInt(stringTokenizer.nextToken());
            int silver = Integer.parseInt(stringTokenizer.nextToken());
            int bronze = Integer.parseInt(stringTokenizer.nextToken());
            medals[i] = new Medal(index, gold, silver, bronze);
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(medals, k));
    }
}

class Medal {
    int index;
    int gold, silver, bronze;

    public Medal(int index, int gold, int silver, int bronze) {
        this.index = index;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

class Solution {
    public int solution(Medal[] medals, int k) {
        ArrayList<Medal> medalList = new ArrayList<>();
        Collections.addAll(medalList, medals);
        medalList.sort(new Comparator<Medal>() {
            @Override
            public int compare(Medal o1, Medal o2) {
                if (o1.gold < o2.gold) {
                    return 1;
                } else if (o1.gold == o2.gold) {
                    if (o1.silver < o2.silver) {
                        return 1;
                    } else if (o1.silver == o2.silver) {
                        if (o1.bronze < o2.bronze) {
                            return 1;
                        } else if (o1.bronze == o2.bronze) {
                            return 0;
                        }
                        return -1;
                    }
                    return -1;
                }
                return -1;
            }
        });
        int answer = 0;
        for (int i = 0; i < medalList.size(); i ++) {
            if (medalList.get(i).index == k) {
                answer = i + 1;
                if (i == 0) {
                    return answer;
                }
                for (int j = i - 1; j >= 0; j --) {
                    if (medalList.get(j).gold == medalList.get(i).gold) {
                        if (medalList.get(j).silver == medalList.get(i).silver) {
                            if (medalList.get(j).bronze == medalList.get(i).bronze) {
                                answer --;
                            } else {
                                return answer;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
