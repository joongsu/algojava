package 백준.그래프; // 1043 - 거짓말

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거짓말 {
    static int N, M;
    static int t;
    static boolean[] knowsTruth;
    static List<List<Integer>> adj = new ArrayList<>();
    static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 출력 : 지민이가 거짓말쟁이로 알려지지 않으면서 과장된 이야기를 할 수 있는 파티의 최댓값

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        knowsTruth = new boolean[N + 1];
        for (int i = 0; i < t; i++) {
            int p = Integer.parseInt(st.nextToken());
            knowsTruth[p] = true;
        }

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();

            int firstPerson = -1;

            for (int j = 0; j < partySize; j++) {
                int p = Integer.parseInt(st.nextToken());
                party.add(p);

                if(j == 0) firstPerson = p;
                else{
                    adj.get(firstPerson).add(p);
                    adj.get(p).add(firstPerson);
                }
            }
            parties.add(party);
        }

        for (int i = 1; i <= N; i++) {
            if (knowsTruth[i]) {
                dfs(i);
            }
        }

        int ans = 0;

        for (List<Integer> party : parties) {
            boolean vis = true;

            for (int person : party) {
                if (knowsTruth[person]) {
                    vis = false;
                    break;
                }
            }
            if(vis) ans++;
        }
        System.out.println(ans);
    }
    static void dfs(int person) {
        for (int nxt : adj.get(person)) {
            if (!knowsTruth[nxt]) {
                knowsTruth[nxt] = true;
                dfs(nxt);
            }
        }
    }
}
