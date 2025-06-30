package 프머스.알고리즘고득점kit.해시;

import java.util.*;
class 폰켓몬 {
    public int solution(int[] nums) {

        // n 짝수 , n마리중 N/2 마리 가져가도 됨
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        return Math.min(set.size(),nums.length/2);
    }
}
