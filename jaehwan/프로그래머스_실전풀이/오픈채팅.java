import java.util.*;

class Solution { //[PGM-42888]오픈채팅방 jaehwan solved
        public String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap<>();
            int count=0;
            int idx=0;
            for(int i = 0; i < record.length; i++){
                String[] str = record[i].split(" ");

                if(str[0].equals("Enter")){
                    map.put(str[1],str[2]);
                }
                else if(str[0].equals("Leave")){
                    continue;
                }
                else {
                    map.put(str[1],str[2]);
                    count++;
                }
            }
            String[] answer = new String[record.length - count];

            for(int i = 0; i < record.length; i++){
                String[] str = record[i].split(" ");
                String name = map.get(str[1]);
                if(str[0].equals("Enter")){
                    answer[idx++]=name+"님이 들어왔습니다.";
                }
                else if(str[0].equals("Leave")){
                    answer[idx++]=name+"님이 나갔습니다.";
                }
            }
            return answer;
    }
}
