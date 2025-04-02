package x06;    // 2164 - 카드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() != 1) {
            q.poll();
            int first = q.poll();
            q.offer(first);
        }
        System.out.println(q.peek());
    }
}
