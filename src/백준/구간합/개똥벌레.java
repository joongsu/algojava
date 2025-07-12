package 백준.구간합; // 3020 - 개똥벌레

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 개똥벌레 {
    static int N, H;
    public static void main(String[] args) throws IOException {
        // 동굴 길이 N , 높이 H
        // 첫번째 석순 , 종유석과 석순 번걸아가며 나옴
        // 출력 : 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그 구간 출력
        // ex) 구간 4 -> 3인 석순 , 4인 석순 사이  즉, 석순 4까지 다 부숨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 2]; // 석순
        int[] top = new int[H + 2]; // 종유석


        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if(i % 2 == 0) bottom[h]++;
            else top[h]++;
        }
        // 석순 -> 높이 h인 석순은 높이 h 이하 구간에 영향을 줌
        // 종유석 -> 높이 h인 석순은 (H-h+1) 이상 구간에 영향을 줌

        for (int i = H; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1]; // top[i] -> 높이 i 이상인 종유석
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int h = 1; h <= H; h++) {
            int crash = bottom[h] + top[H - h + 1];

            if (crash < min) {
                min = crash;
                cnt = 1;
            } else if (crash == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
