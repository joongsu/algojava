package x14;        // 2461 - 대표 선수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 대표선수 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<int[]> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                adj.add(new int[]{v, i}); // (값, 그룹번호)
            }
        }

        adj.sort(Comparator.comparingInt(a -> a[0]));

        int left = 0, ans = Integer.MAX_VALUE;
        int[] cnt = new int[N];
        int groups = 0; //현재 포함된 그룹의 수


        for (int right = 0; right < adj.size(); right++) {
            int group = adj.get(right)[1];

            if(cnt[group] == 0) groups++;
            cnt[group]++;

            // 모든 그룹이 포함되면 left 증가하며 최소값 찾기
            while (groups == N) {
                int diff = adj.get(right)[0] - adj.get(left)[0];
                ans = Math.min(ans, diff);

                // left 포인터 이동
                int leftClass = adj.get(left)[1];
                cnt[leftClass]--;

                if (cnt[leftClass] == 0) {
                    groups--;
                }

                left++;
            }
        }

        System.out.println(ans);
    }
}
