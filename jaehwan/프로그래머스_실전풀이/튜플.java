import java.util.*;
import java.util.stream.IntStream;
class 튜플 {//[PGM-64065]튜플 jaehwan solved 
    public int[] solution(String s) {
        String str = s.replace("{","");
        str = str.replace("},","/").replace("}", "");
        String[] tuple = str.split("/");

        //길이가 짧은 튜플부터 정렬
        Arrays.sort(tuple, (o1, o2) -> o1.length() - o2.length());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tuple.length; i++) {
            String[] cur = tuple[i].split(",");

            for (int j = 0; j < cur.length; j++) {
                int num = Integer.parseInt(cur[j]);
                if(!list.contains(num)){ //해당 값이 list에 없을때만
                    list.add(num);
                }
            }
        }

        return list.stream().flatMapToInt(i -> IntStream.of(i)).toArray();
    }
}
