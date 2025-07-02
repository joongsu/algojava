package x13;    // 10816 - 숫자 카드 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드2 {
    static int n,m;
    static int[] arr = new int[500002];
    static int[] brr = new int[500002];
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr, 0, n);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
            sb.append(search(brr[i])).append(" ");
        }
        System.out.println(sb);

    }

    public static int search(int target) {
        int st = 0;
        int ed = n - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] < target) {
                st = mid + 1;
            } else if (arr[mid] > target) {
                ed = mid - 1;
            }else{
                return map.get(target);
            }
        }
        return 0;
    }
}
