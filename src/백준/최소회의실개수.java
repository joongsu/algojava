package 백준; // 19598 - 최소 회의실 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소회의실개수 {
    static int n, max;
    static class Meeting{
        int start;
        int end;

        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    static Meeting[] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 시작 시간 순으로 정렬
        Arrays.sort(meetings, 0, n, Comparator.comparing(a -> a.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int s = meetings[i].start;
            int e = meetings[i].end;

            while (!pq.isEmpty() && pq.peek() <= s) {
                pq.poll();
            }

            pq.add(e);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}
