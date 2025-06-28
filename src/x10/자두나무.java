package x10;    // 2240 - 자두나무

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자두나무 {
    static int t,w;
    static int[] arr = new int[1005];
    static int[][][] d = new int[1005][32][3];
    public static void main(String[] args) throws IOException {
        //자두는 t초간 떨어진다. 자두는 최대 w번만 움직이고 싶어 한다.
        // t = 7 , w = 2 -> 7초동안 떨어지며 자두는 2번만 움직이고 싶어함
        // 자두가 받을 수 있는 자두의 최대 개수 출력
        // 현재 자두 1번 나무 위치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //d[i][j][k] = 현재 i초이며 , i초까지 j만큼 이동했으며 , 그때의 자두 위치는 k일 때
        // -> 먹을 수 있는 자두의 최대 개수
        // 1번째 자두나무에서 자두가 떨어지거나 or 2번째 자두나무에서 떨어지거나
        // 그대로 있거나 or 옆 나무로 이동하거나

        //초기 -> d[0][0][1] = 0
        for (int i = 1; i <= t; i++) {
            // 자두를 한 번도 이동하지 않고 (0번 이동) 계속 1번 나무에 있다면,
            // 현재 떨어진 자두가 1번 나무라면 받음
            d[i][0][1] = d[i - 1][0][1] + (arr[i] == 1 ? 1 : 0);
            for (int j = 1; j <= w; j++) {
                // 초 보다 더 이동할 수 없다
                if(i < j) break;
                if (arr[i] == 1) {
                    d[i][j][1] = Math.max(d[i - 1][j - 1][2], d[i - 1][j][1]) + 1;
                    d[i][j][2] = Math.max(d[i - 1][j - 1][1], d[i - 1][j][2]);
                }else{
                    d[i][j][1] = Math.max(d[i - 1][j - 1][2], d[i - 1][j][1]);
                    d[i][j][2] = Math.max(d[i - 1][j - 1][1], d[i - 1][j][2]) + 1;
                }
            }
        }

        int max = 0;
        for (int j = 0; j <= w; j++) {
            max = Math.max(max, Math.max(d[t][j][1], d[t][j][2]));
        }
        System.out.println(max);

    }
}
