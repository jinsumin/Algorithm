package level2.the_song_just_now_kakao_2018;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Crab on 2020-05-06.
 */
public class Main {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {
                "12:00,12:14,HELLO,CDEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(m, musicinfos));
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        return answer;
    }

    private static class Song {
        private int startTime;
        private int endTime;
        private String songName;
        private String codes;
        private String playedCodes = "";

        public void setPlayedCodes(String playedCodes) {
            this.playedCodes = playedCodes;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public void setCodes(String codes) {
            this.codes = codes;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public String getSongName() {
            return songName;
        }

        public String getCodes() {
            return codes;
        }

        public String getPlayedCodes() {
            return playedCodes;
        }

        public Song(int startTime, int endTime, String songName, String codes) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.songName = songName;
            this.codes = codes;
        }
    }
}
