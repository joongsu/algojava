package 백준; // 1781 - 컵라면

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 컵라면 {
    static int n;
    static long max;
    static class Cup{
        int deadLine;
        int value;

        Cup(int d, int v) {
            this.deadLine = d;
            this.value = v;
        }
    }
    static Cup[] cups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        cups = new Cup[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cups[i] = new Cup(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        // deadline 정렬 -> 같은 경우 value 기준 내림차순 정렬
        Arrays.sort(cups,0,n,(a,b) -> {
            if (a.deadLine == b.deadLine) {
                return b.value - a.value;
            }
            return a.deadLine - b.deadLine;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Cup cup : cups) {
            pq.add(cup.value);
            if (pq.size() > cup.deadLine) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()) max += pq.poll();
        System.out.println(max);
    }
}
