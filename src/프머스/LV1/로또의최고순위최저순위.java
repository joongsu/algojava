package 프머스.LV1;

import java.util.*;

class 로또의최고순위최저순위 {
    static int zero,cnt;
    static Map<Integer,Integer> map = Map.of(
            6,1,
            5,2,
            4,3,
            3,4,
            2,5
    );

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        for(int i = 0 ; i< 6 ; i++){
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            for(int j = 0 ; j< 6 ; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }
        return new int[] {
                map.getOrDefault(cnt+zero, 6),
                map.getOrDefault(cnt,6)
        };
    }
}
