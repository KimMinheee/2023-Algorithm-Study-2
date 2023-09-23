package rudgusee.DP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGM_English {

    //1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기
    //규칙:
    //1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
    //2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
    //3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
    //4. 이전에 등장했던 단어는 사용할 수 없습니다.
    //5. 한 글자인 단어는 인정되지 않습니다.

    //사람의 수 n과 사람들이 순서대로 말한 단어 words
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        boolean flag = true;

        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])){   // 이전에 등장한 단어인경우
                //번호 = (i%n) + 1 , 차례 = (i/n) + 1
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                //탈락자 생김
                flag = false;
                break;
            }

            list.add(words[i]); // 현재 단어 리스트에 넣기

            //이전 끝단어와 현재 첫단어가 다른경우 - 끝말잇기가 아닌경우
            //가장 첫번째 단어는 확인할 필요가 없으므로 i > 0 이라는 조건을 추가
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                //번호 = (i%n) + 1 , 차례 = (i/n) + 1
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                //탈락자 생김
                flag = false;
                break;
            }
        }
        //탈락자가 생기지 않는다면 flag의 값은 그대로 true이므로,
        //마지막에 true일경우 [0, 0]을 리턴해준다.
        if(flag) return new int[]{0, 0};

        //(가장 먼저 탈락하는 사람의 번호) 번호와 (그 사람이 자신의 몇 번째 차례에 탈락하는지) 차례
        return answer;
    }

    public static void main(String[] args) {
        PGM_English pgmEnglish = new PGM_English();

        String[] word1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] word2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] word3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(pgmEnglish.solution(3, word1)));
        System.out.println(Arrays.toString(pgmEnglish.solution(5, word2)));
        System.out.println(Arrays.toString(pgmEnglish.solution(2, word3)));
    }
}
