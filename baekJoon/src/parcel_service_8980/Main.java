package parcel_service_8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Crab on 2020-09-24.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberOfVillage = Integer.parseInt(stringTokenizer.nextToken());
        int capacityOfTruck = Integer.parseInt(stringTokenizer.nextToken());
        int numberOfBoxData = Integer.parseInt(bufferedReader.readLine());
        int[][] data = new int[numberOfBoxData][3];
        for (int i = 0; i < numberOfBoxData; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            data[i][0] = Integer.parseInt(stringTokenizer.nextToken()); // start
            data[i][1] = Integer.parseInt(stringTokenizer.nextToken()); // end
            data[i][2] = Integer.parseInt(stringTokenizer.nextToken()); // boxes
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(numberOfVillage, capacityOfTruck, numberOfBoxData, data));
    }
}

class Solution {
    public int solution(int numberOfVillage, int capacityOfTruck, int numberOfBoxData, int[][] data) {
        int answer = 0;
        ArrayList<Data> arrayList = new ArrayList<Data>();
        for (int i = 0; i < numberOfBoxData; i++) {
            int start = data[i][0];
            int end = data[i][1];
            int boxes = data[i][2];
            arrayList.add(new Data(start, end, boxes));
        }
        arrayList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.end > o2.end) {
                    return 1;
                } else if (o1.end == o2.end) {
                    if (o1.start > o2.start) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        int currentCapacity = 0;
        int currentVillage = 1;
        for (int i = 0; i < arrayList.size(); i ++) {
            if (arrayList.get(i).start >= currentVillage) {
                if (arrayList.get(i).boxes + currentCapacity < capacityOfTruck) {
                    currentCapacity += arrayList.get(i).boxes;
                } else {
                    arrayList.get(i).boxes = capacityOfTruck - currentCapacity;
                }
            } else {
                answer -= arrayList.get(i).boxes;
            }
            answer += arrayList.get(i).boxes;
            currentVillage = arrayList.get(i).end;
        }
        print(arrayList);
        return answer;
    }

    private void print(ArrayList<Data> arrayList) {
        for (Data data : arrayList) {
            System.out.println(data.start + " " + data.end);
        }
    }

    public static class Data {
        int start, end, boxes;

        public Data(int start, int end, int boxes) {
            this.start = start;
            this.end = end;
            this.boxes = boxes;
        }
    }
}
