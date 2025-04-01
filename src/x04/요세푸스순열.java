package x04;    // 1158 - 요세푸스순열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스순열 {
    public static void main(String[] args) throws IOException {
        //<3, 6, 2, 7, 5, 1, 4>
        // (7,3)    1 2 3 4 5 6 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        System.out.print("<");
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            if (q.size() != 1) {
                System.out.print(q.poll() + ", ");
            }else{
                System.out.print(q.poll());
            }
        }
        System.out.print(">");
    }
}
