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
                //정규식[^...] skill에 포함된 문자들을 제외한 모든 문자를 선택하도록 정의
                String str=s.replaceAll("[^"+skill+"]",""); //다 날려버림
                if(skill.indexOf(str)==0){//indexOf(String)는 인자로 전달된 String의 index를 리턴
                    answer++;
                }
            }
            return answer;
        }
    }
}
