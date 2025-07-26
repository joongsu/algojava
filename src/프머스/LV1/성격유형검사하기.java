package 프머스.LV1;

import java.util.*;

class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        // AN -> 매우동의 네오 , 매우 비동의 어피치
        int length = survey.length;
        Map<String, Integer> map = new HashMap<>();

        List<String> keys = Arrays.asList("R","T","C","F","J","M","A","N");
        int[] scores = {0,3,2,1,0,1,2,3};

        for(String key : keys){
            map.put(key,0);
        }

        for(int i = 0 ; i < length ; i++){
            if(choices[i] == 4) continue;

            char[] chars = survey[i].toCharArray();

            int cri = choices[i];
            int score = scores[choices[i]];


            if(cri > 4){
                map.put(String.valueOf(chars[1]), map.get(String.valueOf(chars[1])) + score);
            }else{
                map.put(String.valueOf(chars[0]), map.get(String.valueOf(chars[0])) + score);
            }

        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 8 ; i+=2){
            String s = keys.get(i);
            String s1 = keys.get(i+1);

            if(map.get(s) == map.get(s1)){
                sb.append(s.compareTo(s1)<0 ? s : s1);
                continue;
            }

            if(map.get(s) < map.get(s1)){
                sb.append(s1);
            }else{
                sb.append(s);
            }
        }

        return sb.toString();
    }
}
