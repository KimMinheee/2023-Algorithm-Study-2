package minhee.구현;
import java.util.*;

class P12981_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int peopleCount = 0;
        int gameCount = 1;
        String prev = "";
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String now = words[i];
            peopleCount++;

            if(i != 0){
                //끝말 확인, 이미 존재하는 단어인지 확인
                char prevChar = prev.charAt(prev.length()-1);
                char nowChar = now.charAt(0);
                if(prevChar != nowChar || map.containsKey(now)){
                    answer[0] = peopleCount;
                    answer[1] = gameCount;
                    break;
                }

            }

            map.put(now, 0);
            prev = now;

            if(peopleCount == n){
                peopleCount = 0;
                gameCount ++;
            }
        }

        return answer;
    }
}
