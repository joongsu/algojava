package 프머스;

import java.util.*;
class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();

        int answer = 0;

        // 전체 숫자별 갯수
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        // 내림차순 정렬

        for(int i : list){
            k -= map.get(i);
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }
}
