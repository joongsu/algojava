package 프머스.알고리즘고득점kit.완전탐색;

import java.util.*;
class 소수찾기 {
    static String n;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        int answer = 0;
        n = numbers;
        dfs("");
        for(int k : set){
            if(isPrime(k)){
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(String cur){
        if(!cur.equals("")){
            set.add(Integer.parseInt(cur));
        }

        for(int i = 0 ; i<n.length() ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + n.charAt(i));
                visited[i] = false;
            }
        }
    }


    public static boolean isPrime(int k){
        if(k <= 1) return false;

        for(int i = 2 ; i * i <= k ; i++){
            if(k % i == 0) return false;
        }
        return true;
    }
}
