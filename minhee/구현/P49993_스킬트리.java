package minhee.구현;

import java.util.Arrays;

public class P49993_스킬트리 {
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        boolean[] isUsed = new boolean[skill.length()];
        char[] arr = skill.toCharArray();

        int skillIdx = -1;
        boolean isNotValid = false;

        for (String skillTree : skillTrees) {
            //초기화
            Arrays.fill(isUsed, false);
            isNotValid = false;
            skillIdx = -1;

            //skill_tree 중 skill에 해당하는 값이 있는지 확인
            for (int i = 0; i < skillTree.length(); i++) {
                if (isNotValid) {
                    break; //다음 단어로 넘어가야 함
                }
                if (!skill.contains(skillTree.charAt(i) + "")) continue;

                int tmpIdx = skill.indexOf(skillTree.charAt(i));
                if (tmpIdx < skillIdx) {
                    isNotValid = true;
                }
                skillIdx = tmpIdx;
                isUsed[skillIdx] = true;

            }

            if (isValidSkillTree(isUsed) && !isNotValid) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValidSkillTree(boolean[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] == false) && (arr[i + 1] == true)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P49993_스킬트리 s = new P49993_스킬트리();
        int answer = s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(answer);
    }
}

