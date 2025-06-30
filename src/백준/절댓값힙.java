package 백준; // 11286 - 절댓값 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 절댓값힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());

            if (v < 0) {
                v *= -1;
                map.put(v, map.getOrDefault(v, 0) + 1);
                pq.add(v);
            } else if (v > 0) {
                pq.add(v);
            }else{
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    int min = pq.poll();
                    if (map.getOrDefault(min, 0) == 0) {
                        sb.append(min).append("\n");
                        continue;
                    }
                    int k = map.get(min);
                    sb.append(min * -1).append("\n");
                    map.put(min, k - 1);
                }
            }
        }
        System.out.println(sb);
    }
}
