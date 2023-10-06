class 배열자르기 {//[PGM-87390]배열자르기 jaehwan solved 
    public int[] solution(int n, long left, long right) {
         int[] answer = new int[(int)(right - left) + 1];
        
        for(int i = 0; i < answer.length; i++){
            int row = (int)((i + left) / n) + 1; 
            int col = (int)((i + left) % n) + 1;
            answer[i] = Math.max(row, col); //행렬
        }
        return answer;
    }
}
//행과 열중 가장 큰수로 계속 갱신되는 일차원 행렬 값을 가지게된다 1,2,3,2,2,3,3,3,3
