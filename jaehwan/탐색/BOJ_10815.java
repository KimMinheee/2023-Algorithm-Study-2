import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10815 {//[BOJ_10815]카드찾기 jaehwan solved - hash 사용
    //시간복잡도 (n+m)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> cardSet = new HashSet<>();//중복허용하지 않는 자료구조

        for (int i = 0; i < n; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (cardSet.contains(card)) { //요소검색속도 O(1)
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}

/*
시간복잡도 n*m
public class BOJ_10815 {
    static ArrayList<Integer> arr1=new ArrayList<>();
    static ArrayList<Integer> arr2=new ArrayList<>();
    static ArrayList<Integer> answer=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){//주어진 카드
            arr1.add(Integer.parseInt(st.nextToken()));
        }
        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){ //탐색 카드
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        for(Integer i:arr2){
            boolean flag=false;
            for(Integer j:arr1){
                if(i==j){flag=true;
                break;
                }
            }
            if(flag)answer.add(1);
            else answer.add(0);
        }
        for(Integer i:answer){
            System.out.print(i+" ");
        }
    }
}
*/
