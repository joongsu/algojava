package 프머스.LV2;

class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];


        for(int i = 0 ; i< prices.length ; i++){
            for(int j = i + 1 ; j < prices.length ; j++){
                answer[i] += 1;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }

        return answer;
    }
}
