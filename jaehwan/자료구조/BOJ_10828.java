import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {//[BOJ_10828]스택 jaehwan solved - 스택 사용 
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arry=new ArrayList<>();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n=Integer.parseInt(br.readLine());

        Stack<Integer> st=new Stack();
        for(int i=0; i<n;i++){
            String string=br.readLine();
            if(string.contains(" ")){ //문자열에 포함되어 있는지 확인하는 메소드
                stringTokenizer = new StringTokenizer(string," ");
                String push=stringTokenizer.nextToken();
                int num=Integer.parseInt(stringTokenizer.nextToken());
                if(push.equals("push")){
                    st.push(num);
                }
            }
            else if(string.equals("pop")){
                if(st.empty()){
                    arry.add(-1);
                }
                else {arry.add(st.pop());}
            }else if(string.equals("size")){
                arry.add(st.size());
            }else if(string.equals("empty")){
                if(st.empty()){
                    arry.add(1);
                }
                else arry.add(0);
            }else if(string.equals("top")){
                if(st.empty()){
                    arry.add(-1);
                }
                else arry.add(st.peek());
            }
        }
        for (Integer i : arry) {
            System.out.println(i);
        }
    }
}
