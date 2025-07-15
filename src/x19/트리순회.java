package x19;    // 1991 - 트리 순회

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {
    static int n;
    static int[] lc = new int[30];
    static int[] rc = new int[30];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            // 0 : 루트 , 1: 왼쪽 , 2: 오른쪽

            int idx = root - 'A' + 1;
            if(left != '.') lc[idx] = left - 'A' + 1;
            if(right != '.') rc[idx] = right - 'A' + 1;
        }
        preorderTraversal(1);
        sb.append("\n");
        inorderTraversal(1);
        sb.append("\n");
        postorderTraversal(1);
        sb.append("\n");
        System.out.println(sb);
    }

    static void preorderTraversal(int cur) {
        sb.append((char)(cur + 'A' - 1));
        if(lc[cur] != 0) preorderTraversal(lc[cur]);
        if(rc[cur] != 0) preorderTraversal(rc[cur]);
    }

    static void inorderTraversal(int cur) {
        if(lc[cur] != 0) inorderTraversal(lc[cur]);
        sb.append((char)(cur + 'A' - 1));
        if(rc[cur] != 0) inorderTraversal(rc[cur]);
    }

    static void postorderTraversal(int cur) {
        if(lc[cur] != 0) postorderTraversal(lc[cur]);
        if(rc[cur] != 0) postorderTraversal(rc[cur]);
        sb.append((char)(cur + 'A' - 1));
    }
}
