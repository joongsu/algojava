package x13;    // 2295 - 세 수의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 세수의합 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                list.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(list);

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (search(arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    public static boolean search(int target) {
        int st = 0;
        int ed = list.size() - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;
            int v = list.get(mid);
            if (v < target) {
                st = mid + 1;
            } else if (v > target) {
                ed = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
