package level2.skill_tree;

/**
 * Created by Crab on 2020-09-01.
 */
public class Main {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE", "CBADF", "AECB", "BDA"
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(skill, skill_trees));
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            if (isPossibleSkillTrees(skill, skill_tree)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPossibleSkillTrees(String skill, String skill_tree) {
        StringBuilder userSkill = new StringBuilder();
        for (int i = 0; i < skill_tree.length(); i++) {
            int indexOfSkillComponent = foundComponent(skill, skill_tree.charAt(i));
            if (indexOfSkillComponent != -1) {
                userSkill.append(skill.charAt(indexOfSkillComponent));
            }
        }
        if (userSkill.length() == 0) {
            return true;
        }
        return isSubString(skill, userSkill.toString());
    }

    private int foundComponent(String skill, char component) {
        for (int i = 0; i < skill.length(); i++) {
            if (skill.charAt(i) == component) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSubString(String skill, String userSkill) {
        for (int i = 0; i < userSkill.length(); i++) {
            if (userSkill.charAt(i) != skill.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
