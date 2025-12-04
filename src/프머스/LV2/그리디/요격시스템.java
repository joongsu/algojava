package 프머스.LV2.그리디;

import java.util.Arrays;

class 요격시스템 {
    public int solution(int[][] targets) {

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int last = -1;

        for(int[] target : targets){
            int start = target[0];
            int end = target[1];

            if(start >= last){
                answer++;
                last = end;
            }
        }
        return answer;
    }
}
