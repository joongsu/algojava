package 프머스.LV2.완전탐색;

import java.util.*;

class 메뉴리뉴얼 {
    static int n;
    static Map<String, Integer> map;
    static String str;
    public String[] solution(String[] orders, int[] course) {


        List<String> list = new ArrayList<>();
        for(int c : course){

            n = c;
            map = new HashMap<>();

            for(String s : orders){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                str = new String(chars);
                dfs("",0,0);
            }


            int max = 0;
            for(int val : map.values()){
                max = Math.max(max, val);
            }


            for(Map.Entry<String, Integer> entry : map.entrySet()){
                String key = entry.getKey();
                int val = entry.getValue();

                if(val == max && val >= 2){
                    list.add(key);
                }
            }
        }
        Collections.sort(list);


        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    static void dfs(String s , int k, int cnt){

        if(n == cnt){
            map.put(s, map.getOrDefault(s,0) + 1);
            return;
        }

        for(int i = k ; i < str.length() ; i++){
            dfs(s + str.charAt(i) , i + 1 , cnt + 1);
        }

    }
}
