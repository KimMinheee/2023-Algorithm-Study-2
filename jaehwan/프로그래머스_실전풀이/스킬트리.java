public class 스킬트리 {//[PGM-49993]스킬트리 jaehwan
    public static void main(String[] args) {
        Solution s=new Solution();
        s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for(String s:skill_trees){
                String str=s.replaceAll("[^"+skill+"]","");
                if(skill.indexOf(str)==0){
                    answer++;
                }
            }
            return answer;
        }
    }
}
