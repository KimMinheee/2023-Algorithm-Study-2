package programmers;

import java.util.*;

class 파일명정렬 {//[PGM-17686]파일명정렬 jaehwan solved
    public static void main(String[] args) {
        String[] arr={"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        solution(arr);

    }
    static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        //comparator 사용
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String head1 = s1.split("[0-9]")[0]; //숫자를 기준으로 분리
                String head2 = s2.split("[0-9]")[0];
                int result = head1.toLowerCase().compareTo(head2.toLowerCase()); //소문자로 바꿔서 비교

                if(result == 0) // head가 같을 경우
                {
                    s1 = s1.substring(head1.length());
                    s2 = s2.substring(head2.length());
                    //숫자만 뽑아서 따로 비교 숫자 추출후 소문자로 변환후 비교
                    int number1 = Integer.valueOf(s1.toLowerCase().split("[^0-9]")[0]);
                    int number2 = Integer.valueOf(s2.toLowerCase().split("[^0-9]")[0]);

                    result = number1 - number2;
                }
                return result;
            }
        });

        for(int i = 0; i < files.length; i++)
            answer[i] = files[i];

        return answer;
    }
}
