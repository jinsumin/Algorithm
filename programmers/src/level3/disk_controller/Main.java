package level3.disk_controller;

import java.util.*;

/**
 * Created by REMI on 2020-02-12.
 */
public class Main {
    public static void main(String[] args) {
        int[][] jobs = {
                {0, 3},
                {10, 1},
                {1, 9},
                {2, 6}
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(jobs));
    }
}

class Solution {
    private static int runningTime = 0;
    private static int jobTime = 0;
    private List<Job> list = new LinkedList<>();

    private class Job {
        int requestTime, disturbanceTime;

        public Job(int requestTime, int disturbanceTime) {
            this.requestTime = requestTime;
            this.disturbanceTime = disturbanceTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        for (int i = 0; i < jobs.length; i++) {
            list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(list, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.disturbanceTime > o2.disturbanceTime) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (Job job : list) {
            if (job.requestTime <= runningTime) {
                runningTime += job.disturbanceTime;
                jobTime += (jobTime + job.disturbanceTime - job.requestTime);
            } else {
                list.add(list.indexOf(job) + 1, job);
            }
        }
        answer = jobTime / jobs.length;
        return answer;
    }
}
