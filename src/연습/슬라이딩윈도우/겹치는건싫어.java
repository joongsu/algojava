package 연습.슬라이딩윈도우; // 20922 - 겹치는 건 싫어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 겹치는건싫어 {
    static int[] arr;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stIdx = 0;

        int ans = 0;
        Map<Integer, Integer> mapCnt = new HashMap<>();

        for (int en = 0; en < n; en++) {
            mapCnt.put(arr[en], mapCnt.getOrDefault(arr[en], 0) + 1);
            while (mapCnt.get(arr[en]) > k) {
                int count = mapCnt.get(arr[stIdx]) - 1;
                mapCnt.put(arr[stIdx], count);
                stIdx++;
            }

            ans = Math.max(ans, en - stIdx + 1);
        }

        System.out.println(ans);

    }
}
