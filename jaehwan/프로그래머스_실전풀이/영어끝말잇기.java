import java.util.HashMap;

class 영어끝날잇기 {//[PGM-12981]영어끝말잇기 jaehwan solved - 해쉬맵 사용
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String, Integer> Map = new HashMap<String, Integer>();

        Map.put(words[0], 0);//처음 단어는 미리 넣음

        for(int i = 1; i < words.length; ++i) {
            Map.put(words[i], 0); //현재 단어 헤쉬맵에 추가

            //끝말 검사
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer[0] = i % n + 1; //탈락하는 사람 번호
                answer[1] = i / n + 1; //자신이 몇번째 탈락인지
                break;
            }
            if( Map.size() < i + 1){ //현재 등장한 단어의 수가 현재 인덱스
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}
/* 테케 20개중 19개 맞은 실패케이스
package PROGRAMMER;

import java.util.Scanner;

    static class Solution {

        public int[] solution(int n, String[] words) {
            int memberNum = 1;
            int turn = 1; // 라운드 수를 1로 초기화
            int sLength = words.length;
            boolean TF=false;

            for (int i = 1; i < sLength; i++) {


                // 끝말 검사
                if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                    memberNum = (i % n) + 1; // 플레이어 번호를 계산
                    TF=true;
                    break;
                }

                // 중복 검사
                for (int j = i+1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {

                        memberNum = (j % n) + 1; // 플레이어 번호를 계산
                        turn=(j/n)+1;

                        int[] answer = { memberNum, turn };

                        return answer;
                    }
                }

                if (memberNum != 1) {
                    break;
                }

                // 라운드 종료 조건
                if (i == sLength - 1) {
                    turn = 0; // 모든 단어를 사용한 경우 라운드 수를 0으로 설정
                } else if ((i + 1) % n == 0) {
                    turn++; // 라운드가 끝나면 라운드 수를 증가
                }
            }
            if(!TF){ //중복결과 없이 무사통과했으면 0,0
                memberNum=0;
                turn=0;
            }
            int[] answer = { memberNum, turn };

            return answer;
        }
    }

*/
