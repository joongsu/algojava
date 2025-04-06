package x07;    // 11003 - 최솟값찾기

import java.io.*;
import java.util.*;

public class 최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());

            while(!deq.isEmpty() && deq.peekLast()[0] > v) deq.pollLast();

            deq.offer(new int[]{v, i});
            if (deq.peek()[1] < i - L + 1) {
                deq.pollFirst();
            }


            bw.write(deq.peek()[0] + " ");
        }

        bw.flush();
        bw.close();

    }
}
