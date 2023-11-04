package minhee.구현;

class P87390_n2배열자르기 {

    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];

        int idx = 0;
        for(long i=left; i<=right; i++){
            answer[idx++] = Math.max((int)(i/n), (int)(i%n)) + 1;
        }

        return answer;
    }

}
