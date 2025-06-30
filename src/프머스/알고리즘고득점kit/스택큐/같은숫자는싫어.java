package 프머스.알고리즘고득점kit.스택큐;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {


        Deque<Integer> q = new ArrayDeque<>();
        q.offer(arr[0]);
        for(int i = 1 ; i<arr.length ; i++){
            if(q.peekFirst() != arr[i]){
                q.offerFirst(arr[i]);
            }
        }
        int[] answer = new int[q.size()];
        int c = 0;
        while(!q.isEmpty()){
            answer[c] = q.pollLast();
            c++;
        }

        return answer;
    }
}
