package x10;    // 11055 - 가장 큰 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열 {
    static int[] d = new int[1005];
    static int[] arr = new int[1005];
    static int n;
    public static void main(String[] args) throws IOException {
        // d[i] = i 번째 원소를 마지막으로 포함하는 증가 부분 수열 중 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
        }

        // arr[j] < arr[i] 만족 -> arr[j]를 arr[i] 앞에 붙일 수 있을 때 max 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) d[i] = Math.max(d[j] + arr[i], d[i]);
            }
        }

        System.out.println(Arrays.stream(d, 0, n).max().getAsInt());

    }
}
