package 백준; // 11399 - ATM

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(st.nextToken());
            list.add(new int[]{w, i});
        }

        list.sort(Comparator.comparing((int[] a) -> a[0]));

        int sum = 0;
        int[] d = new int[n + 1];
        int i = 0;
        for (int[] k : list) {

            d[i + 1] = d[i] + k[0];
            sum += d[i + 1];
            i++;
        }

        System.out.println(sum);
    }
}
