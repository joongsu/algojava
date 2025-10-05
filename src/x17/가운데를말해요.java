package x17;    // 1655 - 가운데를 말해요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 가운데를말해요 {
    static int N;
    public static void main(String[] args) throws IOException {
        // -99 1 2 5 5 7 10

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 중간값보다 작거나 같은 값들 저장
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // 중간값보다 큰 값들 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() || k <= maxHeap.peek()) {
                maxHeap.offer(k);
            }else{
                minHeap.offer(k);
            }

            // 힙 크기 균형 맞추기 2 1 0   3

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
