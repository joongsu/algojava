package 백준.문자열; // 14425 - 문자열 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열집합 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) {
                cnt += entry.getValue();
            }
        }

        System.out.println(cnt);
    }
}
