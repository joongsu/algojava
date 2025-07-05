package x0D;    // 15686 - 치킨 배달

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
    static int n, m;
    static int[][] board = new int[51][51];

    static int ans = Integer.MAX_VALUE;

    static List<int[]> list = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (board[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }// 0 ~ 4 치킨 , idx = 5
        // idx = 5 , m = 3     // 3 4 1
        comb(0, 0, new ArrayList<>());
        System.out.println(ans);

    }

    static void comb(int start, int cnt, List<Integer> selected) {
        if (cnt >= 1) {
            ans = Math.min(ans, calculate(selected));
        }
        if(cnt == m) return;


        for (int i = start; i < chicken.size(); i++) {
            selected.add(i);
            comb(i + 1, cnt + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    static int calculate(List<Integer> selected) {
        int totalDist = 0;

        for (int[] home : list) {
            int minDist = Integer.MAX_VALUE;

            for (int idx : selected) {
                int[] c = chicken.get(idx);
                int dist = Math.abs(home[0] - c[0]) + Math.abs(home[1] - c[1]);
                minDist = Math.min(dist, minDist);
            }
            totalDist += minDist;
        }
        return totalDist;
    }
}
