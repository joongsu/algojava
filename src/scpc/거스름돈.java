package scpc; // scpc - 거스름돈

import java.util.*;
import java.io.*;

public class 거스름돈 {
    static int T, n;
    static int[] arr = new int[100010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            Map<Integer, Integer> map = new HashMap<>();

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            map.put(500, 0);
            map.put(1000, 0);
            map.put(5000, 0);

            for (int j = 0; j < n; j++) {
                if (arr[j] == 500) { // 거스름돈 안생김
                    map.put(500, map.get(arr[j]) + 1);
                    ans++;
                } else if (arr[j] == 1000) {
                    int k = map.get(500);
                    if(k < 1) break;
                    map.put(1000, map.get(1000) + 1);
                    map.put(500, k - 1);
                    ans++;
                }else{
                    int k1 = map.get(500);
                    int k2 = map.get(1000);
                    if(k1 == 0 || (k1 + k2 * 2) < 9) break;
                    if (k2 >= 4) {
                        map.put(1000, k2 - 4);
                        map.put(500, k1 - 1);
                    }else{
                        int num = (4500 - k2 * 1000);
                        int num2 = num / 500;
                        map.put(1000, 0);
                        map.put(500, k1 - num2);
                    }
                    ans++;
                }
            }
            System.out.println("Case #"+(t+1));
            System.out.println(ans);

            Arrays.fill(arr, 0, n, 0);
        }
    }
}
