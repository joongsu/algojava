package 백준; // 1374 - 강의실

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실 {
    static int n,max;
    static Meeting[] meetings;
    static class Meeting{
        int n;
        long start;
        long end;

        Meeting(int num, long start, long end) {
            this.n = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(
                    Integer.parseInt(st.nextToken()),
                    Long.parseLong(st.nextToken()),
                    Long.parseLong(st.nextToken())
            );
        }

        Arrays.sort(meetings, 0, n, Comparator.comparingLong(m -> m.start));

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long s = meetings[i].start;
            long e = meetings[i].end;

            while (!pq.isEmpty() && pq.peek() <= s) {
                pq.poll();
            }
            pq.add(e);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);

    }
}
