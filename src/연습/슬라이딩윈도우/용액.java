package 연습.슬라이딩윈도우; // 2467 - 용액

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 용액 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = N - 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        while (lt < rt) {
            int dif = arr[lt] + arr[rt];

            pq.offer(new int[]{Math.abs(dif), lt, rt});
            if (dif < 0) {
                lt++;
            } else if (dif > 0) {
                rt--;
            }else{
                break;
            }
        }

        int[] ans = pq.poll();

        System.out.println(arr[ans[1]] + " " + arr[ans[2]]);

    }
}
