package x13;    // 2230 - 수 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
    static int N;
    static long M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long target = arr[i] + M;
            int j = lowerBound(target);
            if(j < N) ans = Math.min(ans, arr[j] - arr[i]);
        }
        System.out.println(ans);
    }

    // 첫번째로 arr[idx] >= key 가 되는 idx를 반환 (없으면 N)
    static int lowerBound(long key) {
        int left = 0;
        int right = arr.length;

        while (left < right) { // 0 1 2 3 4
            int mid = (left + right) / 2;

            if(arr[mid] >= key) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
