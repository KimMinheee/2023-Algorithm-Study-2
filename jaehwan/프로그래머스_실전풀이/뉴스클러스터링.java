package programmers;

import java.util.StringTokenizer;

public class 뉴스클러스터링 {//[PGM-17677]뉴스클러스터링 jaehwan solved 
    public int solution(String str1, String str2) {
        int num = 65536;
        int answer = 0;

        str1=str1.toUpperCase();//대문자로 통일
        str2=str2.toUpperCase();

        String[] arr1=new String[str1.length()-1];
        String[] arr2=new String[str2.length()-1];

        for(int i=0;i<str1.length()-1;i++){
            arr1[i]=str1.substring(i,i+2); //어디부터 어디까지 자를지 +1
        }
        for(int i=0;i<str2.length()-1;i++){
            arr2[i]=str2.substring(i,i+2); //어디부터 어디까지 자를지 +1
        }
        for(int i=0;i< arr1.length;i++){
            if(arr1[i].charAt(0) < 'A' || arr1[i].charAt(0) > 'Z' || arr1[i].charAt(1) < 'A' || arr1[i].charAt(1) > 'Z'){
                arr1[i]="-1";
            }
        }
        for(int i=0;i< arr2.length;i++){
            if(arr2[i].charAt(0) < 'A' || arr2[i].charAt(0) > 'Z' || arr2[i].charAt(1) < 'A' || arr2[i].charAt(1) > 'Z'){
                arr2[i]="-2";
            }
        }
        int count=0; //교집합 수수
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j< arr2.length;j++){
                if(arr1[i].equals(arr2[j])){
                    arr1[i]="-1";
                    arr2[j]="-2";
                    count++;//교집합
                }
            }
        }
        int ans=0;//살아남은 원소개수
        for(int i=0;i<arr1.length;i++){ //-1아닌거 찾아냄
            if(!arr1[i].equals("-1")){
                ans++;
            }
        }
        for(int i=0;i<arr2.length;i++){
            if(!arr2[i].equals("-2")){
                ans++;
            }
        }

        if(count+ans==0){ //교집합 + 살아남은 원소개수
            answer=65536;
        }else answer=(count*num)/(count+ans); // 교집합 / 총개수(합집합)

        return answer;
    }
}

