package 프머스.LV1;

class 일로만들기 {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i = 0 ; i < num_list.length ; i++){
            int v = num_list[i];
            while(v != 1){
                if(v % 2 != 0){
                    v-=1;
                }
                v /=2;
                answer++;
            }
        }
        return answer;
    }
}
