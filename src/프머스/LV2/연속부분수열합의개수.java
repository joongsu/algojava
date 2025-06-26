package 프머스.LV2;

import java.util.*;
class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        //원형 처리를 쉽게 하기 위해 배열을 2배로 확장
        int[] extended = new int[n * 2];
        for(int i = 0  ; i < n * 2 ; i++){
            extended[i] = elements[i % n];
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j =0 ; j < n ; j++){
                int v = 0;
                for(int k = j ; k < j + i ; k++){
                    v += extended[k];
                }
                set.add(v);
            }
        }
        return set.size();
    }
}
