import java.util.Arrays;
import java.util.HashSet;

class Solution {//[PGM-64065]튜플 jaehwan solved 
    public int[] solution(String s) {
        int[] answer = {};
        String strs = s.replace("{","");
        strs = strs.replace("}", " ").trim();
        String[] tuple = strs.split(" ,");
            
        answer = new int[tuple.length];
        HashSet<Integer> hs = new HashSet<Integer>();
         //길이가 짧은 튜플부터 정렬
        Arrays.sort(tuple, (a, b)->(a.length()-b.length()));
        int i = 0;
        for(String str : tuple){
            for(String st : str.split(",")){
                int a  = Integer.parseInt(st.trim());
                if(hs.contains(a))continue;
                hs.add(a);
                answer[i++] = a;
            }
        }
        return answer;
    }
}
