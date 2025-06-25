package 프머스.LV2;

import java.util.*;
class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] d = new int[land.length][4];
        // n행 4열 , 4칸중 1칸 밟고 내려옴 , 같은열 연속으로 못밟음
        //d[i] = i번째 행의 최댓값
        //d[i][j] = i행의 j칸을 밟은 경우의 합
        //d[i][j] = Math.max(d[i][j], ~ d[]) + land[i][j]
        for(int i = 0 ; i < 4 ; i++){
            d[0][i] = land[0][i];
        }
        for(int i = 1 ; i < land.length ; i++){
            for(int j = 0  ; j < 4 ; j++){
                int max = 0 ;
                for(int k = 0 ; k < 4 ; k++){
                    if(k != j){
                        max = Math.max(max,d[i-1][k]);
                    }
                }
                d[i][j] = max + land[i][j];
            }
        }

        return Arrays.stream(d[land.length - 1]).max().getAsInt();
    }
}
