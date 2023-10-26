package programmers;

import java.util.*;

public class 주차요금계산 {//[PGM-92341]주차요금계산 jaehwan solved - hashMap 사용 
    public static void main(String[] args) {
        int[] fees={180, 5000, 10, 600};
        String[] records={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Solution s=new Solution();
        s.solution(fees,records);
    }
    static class Solution {
        public int[] solution(int[] fees, String[] records) {//fees:기본시간,기본요금,단위시간,단위요금 records:시각,차량번호,내역
            HashMap<String, Integer> parking = new HashMap<>();
            HashMap<String, Integer> fee = new HashMap<>();

            int[] answer = {};
            int basicTime=fees[0];//기본 시간
            int basicCost=fees[1];//기본 요금
            int partMin=fees[2];//단위 시간
            int partCost=fees[3];//단위 요금

            //기록
            int rTime=0;//시간(분)
            String rCAR="";//차량번호
            String rec="";//내역 입차,출차

            for(String r : records){
                String[] record=r.split(" ");
                String[] time=record[0].split(":");

                rTime=Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]); //주차시간(분으로 계산)
                rCAR=record[1];//차량번호
                rec=record[2];//출입

                if(rec.equals("IN")){
                    parking.put(rCAR,rTime);
                }else {
                    if(!fee.containsKey(rCAR)){ //주차한 시간을 차량번호를 key로 담음
                        fee.put(rCAR, rTime - parking.get(rCAR));
                    }else {
                        fee.put(rCAR,fee.get(rCAR)+(rTime-parking.get(rCAR)));
                    }
                    parking.remove(rCAR);//출고했으니 주차장에서 뻼
                }
            }
            int end=(23*60)+59;
            for(String key:parking.keySet()){
                if(!fee.containsKey(key)){
                    fee.put(key,end-parking.get(key));
                }else {
                    fee.put(key,fee.get(key)+(end-parking.get(key)));
                }
            }
            Map<String, Integer> sortedFee = new TreeMap<>(fee);

            //요금 계산
            answer = new int[fee.size()];
            int i = 0;
            for (String car : sortedFee.keySet()) { //key = 차량번호
                int min = sortedFee.get(car); //분
                //요금 = 기본요금 + ((min-기본시간)/단위시간) *단위요금
                if(min<=basicTime) { //기본요금 이하 시간
                    answer[i++] = basicCost;
                }else { //기본요금 이상 시간
                    answer[i++] = (int) (basicCost + Math.ceil((double)(min-basicTime)/partMin)*partCost) ;
                }
            }
            return answer;//차량번호 작은순으로 요금 담아서 반환
        }
    }
}
