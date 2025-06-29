package 백준; // 1202 - 보석 도둑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑 {

    static long[][] v;
    static int n, k;
    static long sum;
    static long[] c;
    public static void main(String[] args) throws IOException {
        // n = 보석 총 개수 , k = 가방 개수
        // m = 무게 , v = 가격
        // c = 최대 무게
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        v = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Long.parseLong(st.nextToken());
            v[i][1] = Long.parseLong(st.nextToken());
        }
        c = new long[k];
        for (int i = 0; i < k; i++) {
            c[i] = Long.parseLong(br.readLine());
        }
        // 보석 무게순으로 정렬 , 오름차순
        Arrays.sort(v, Comparator.comparingLong(g -> g[0]));
        Arrays.sort(c);

        int index = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            long cur = c[i];

            while (index < n && v[index][0] <= cur) {
                pq.add(v[index][1]);
                index++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);

    }
}
