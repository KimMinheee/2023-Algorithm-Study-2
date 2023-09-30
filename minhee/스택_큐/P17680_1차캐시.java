package minhee.스택_큐;

import java.util.*;

class P17680_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> deque = new ArrayDeque<>();
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            String tmpCity = city.toLowerCase();

            if(deque.contains(tmpCity)){
                //캐시에 단어가 존재하는 경우
                deque.remove(tmpCity);
                deque.addLast(tmpCity);
                answer += 1;
            }
            else{
                //캐시에 단어가 존재하지 않는 경우
                if(deque.size() == cacheSize){
                    deque.removeFirst();
                }
                deque.addLast(tmpCity);
                answer += 5;
            }
        }

        return answer;
    }
}
