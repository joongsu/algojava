package x07;    // 1021 - 회전하는 큐


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        int size = list.size();

        for (int i = 0; i < m; i++) {

            int k = Integer.parseInt(st.nextToken());

            if (!list.isEmpty() && k == list.peek()) {
                list.removeFirst();
                size--;
                continue;
            }

            int search = list.indexOf(k);
            int cta = size % 2 == 0 ? size / 2 -1 : size / 2;

            if (search <= cta) {
                for (int j = 0; j < search; j++) {
                    int v = list.removeFirst();
                    list.add(v);
                    count++;
                }
            }else {
                int num = size - search;
                for (int j = 0; j < num; j++) {
                    int v = list.removeLast();
                    list.addFirst(v);
                    count++;
                }
            }
            list.removeFirst();
            size--;
        }
        System.out.println(count);
    }
}
