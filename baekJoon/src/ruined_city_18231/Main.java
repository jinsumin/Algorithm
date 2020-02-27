package ruined_city_18231;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by REMI on 2020-01-14.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    private static ArrayList<Integer>[] cities;
    private static int[] savedCities;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = scanner.nextInt();
        int numberOfRoads = scanner.nextInt();
        savedCities = new int[numberOfCities + 1];
        cities = new ArrayList[numberOfCities + 1];
        for(int i = 0; i < numberOfRoads; i ++) {
            int cityOfU = scanner.nextInt();
            int cityOfV = scanner.nextInt();
            cities[cityOfU] = new ArrayList<>();
            cities[cityOfU].add(cityOfV);
        }
        int numberOfRuinedCities = scanner.nextInt();
        int[] ruinedCities = new int[numberOfRuinedCities + 1];
        for(int i = 1; i < numberOfRuinedCities + 1; i ++) {
            ruinedCities[i] = scanner.nextInt();
        }
        for(int i = 1; i < numberOfCities + 1; i ++) {
            savedCities[ruinedCities[i]] ++;
            for(int j : cities[ruinedCities[i]]) {
                savedCities[cities[ruinedCities[i]].get(j)] ++;
            }
        }
        int numberOfFirstRuinedCities = 0;
        for(int i = 1; i < numberOfCities + 1; i ++) {
            if(savedCities[i] == 1) {
                numberOfCities ++;
            }
        }
        if(numberOfCities == 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(numberOfFirstRuinedCities);
        for(int i = 1; i < numberOfCities + 1; i ++) {
            if(savedCities[i] == 1) {
                System.out.println((i + 1));
            }
        }
    }
}
