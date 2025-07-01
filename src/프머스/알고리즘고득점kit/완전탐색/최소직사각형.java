package 프머스.알고리즘고득점kit.완전탐색;

class 최소직사각형 {
    public int solution(int[][] sizes) {


        int w = 0;
        int h = 0;

        for(int[] card : sizes){
            h = Math.max(h , Math.max(card[0],card[1]));
            w = Math.max(w , Math.min(card[0],card[1]));
        }
        return h * w;
    }
}
