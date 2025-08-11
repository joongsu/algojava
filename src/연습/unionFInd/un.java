package 연습.unionFInd;

import java.util.Arrays;

public class un {
    static int[] p = new int[11];
    public static void main(String[] args) {
        Arrays.fill(p, -1);

    }
    // 단순 랭크
    static int find(int x) {
        while(p[x] > 0)
            x = p[x];
        return x;
    }

    //경로압축
    static int find2(int x) {
        if(p[x] < 0)
            return x;
        return p[x] = find2(p[x]);
    }

    static boolean uni2(int u, int v) {
        u = find2(u);   // 루트 정점
        v = find2(v);

        if(u == v)
            return false;

        if(p[u] == p[v])    //랭크 1 증가 (v를 u의 자식으로)
            p[u]--;

        if(p[u] < p[v]) { //u의 랭크가 v보다 더 큼
            p[v] = u;
        }else{  // v의 랭크가 u보다 더 큼
            p[u] = v;
        }

        return true;
    }
}
