package 프머스.LV3;

import java.util.*;
class 정수삼각형 {
    public int solution(int[][] triangle) {
        int[][] d = new int[triangle.length+1][triangle.length+1];

        d[1][1] = triangle[0][0];
        int n = triangle.length;

        for(int i = 2 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                d[i][j] = Math.max(d[i-1][j-1],d[i-1][j]) + triangle[i-1][j-1];
            }
        }
        return Arrays.stream(d[n]).max().getAsInt();
    }
}
