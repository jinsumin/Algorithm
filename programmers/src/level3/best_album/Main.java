package level3.best_album;

import java.util.*;

/**
 * Created by REMI on 2020-01-21.
 */
public class Main {
    public static void main(String[] args) {
        String[] genres = {
                "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = {
                500, 600, 150, 800, 2500
        };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(genres, plays)));
    }
}

class Solution {

    public static class Album {
        int uniqueNumber;
        String genre;
        int playTime;

        public Album(int uniqueNumber, String genre, int playTime) {
            this.uniqueNumber = uniqueNumber;
            this.genre = genre;
            this.playTime = playTime;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList answerList = new ArrayList();
        HashMap<String, Integer> hashMap = new HashMap<>();
        Album[] albums = new Album[genres.length];
        for (int i = 0; i < genres.length; i ++) {
            albums[i] = new Album(i, genres[i], plays[i]);
            if (hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
            } else {
                hashMap.put(genres[i], plays[i]);
            }
        }
        ArrayList setList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(setList, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1 : -1;
            }
        });
        System.out.println(setList);
        for (int i = 0; i < setList.size(); i ++) {
            String temp = setList.get(i).toString();
            String[] splitTemp = temp.split("=");
            String genre = splitTemp[0];
            HashMap<Integer, Integer> genreHashMap = new HashMap<>();
            for (int j = 0; j < albums.length; j ++) {
                if (genre.equals(albums[j].genre)) {
                    genreHashMap.put(albums[j].playTime, albums[j].uniqueNumber);
                }
            }
            ArrayList albumList = new ArrayList<>(hashMap.entrySet());
            Collections.sort(albumList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getKey() > o1.getKey() ? 1 : -1;
                }
            });
            System.out.println(albumList);
            for (int j = 0; j < albumList.size(); j ++) {
                answerList.add(albumList.get(j));
            }
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i ++) {
            answer[i] = (int) answerList.get(i);
        }
        return answer;
    }
}
