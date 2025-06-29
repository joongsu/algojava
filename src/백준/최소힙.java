package 백준; // 1927 - 최소 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.add(num);
            }else{
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
