package x14;    // 13144 - List of Unique Numbers

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListofUniqueNumbers {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sto.nextToken());
        arr = new int[N];

        sto = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }

        boolean[] vis = new boolean[100005];

        int en = 0;
        long ans = 0L;

        for (int st = 0; st < N; st++) {

            while (en < N && !vis[arr[en]]) {
                vis[arr[en]] = true;
                en++;
            }

            ans += (en - st);
            vis[arr[st]] = false;

        }

        System.out.println(ans);
    }
}
