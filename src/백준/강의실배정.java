package 백준; // 11000 - 강의실 배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
    static long[][] v;
    static int n;
    public static void main(String[] args) throws IOException {
        // si에 시작 -> ti 에 끝나는 N개의 수업

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Long.parseLong(st.nextToken());
            v[i][1] = Long.parseLong(st.nextToken());
        }

        // v 배열의 첫번째 원소 v[0]을 기준으로 비교
        Arrays.sort(v, 0, n, Comparator.comparingLong(a -> a[0]));

        PriorityQueue<Long> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            long start = v[i][0];
            long end = v[i][1];

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}
