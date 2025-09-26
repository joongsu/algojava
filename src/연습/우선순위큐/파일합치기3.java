package 연습.우선순위큐;   // 13975 - 파일합치기 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long ans = 0;
            pq.clear();

            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while (!pq.isEmpty()) {
                if(pq.size() == 1) break;

                long sum = pq.poll() + pq.poll();
                ans += sum;
                pq.add(sum);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
