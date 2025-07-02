package x13;    // 18870 - 좌표 압축

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축 {
    static int n;
    static int[] arr ;
    static int[] brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        brr = arr.clone();
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],cur++);
            }
        }

        for (int i : brr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
