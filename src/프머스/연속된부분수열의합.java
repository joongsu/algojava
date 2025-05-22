package 프머스;

// 투포인터 활용 (left, right)

class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int sum = 0;
        int size = sequence.length;


        for(int right = 0 ; right < sequence.length ; right++){
            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left];
                left++;
            }

            if(sum == k){
                if(size > right - left){

                    answer[0] = left;
                    answer[1] = right;

                    size = right - left;
                }
            }

        }
        return answer;
    }
}
