package 프머스.알고리즘고득점kit.해시;

import java.util.*;
class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();

        for(String s : participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s : completion){
            map.put(s, map.get(s) -1);
        }
        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
