package 연습.트리;

import java.util.*;

public class tree {
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] p = new int[10];
    static int[] depth = new int[10];

    public static void main(String[] args) {

    }

    static void bfs(int root) {

        // 각 정점의 부모 정보를 BFS로 알아 낼 수 있다.
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cur = q.poll();

            System.out.print(cur + " ");

            for (int nxt : adj.get(cur)) { // 자식 노드
                if(p[cur] == nxt) continue; // nxt 가 cur의 부모인지 확인
                p[nxt] = cur;   // nxt의 부모를 cur로
                q.offer(nxt);
            }
        }
    }

    static void bfsDepth(int root) {
        // depth 계산도 가능하다. 자식의 depth = 부모의 depth + 1
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cur = q.poll();

            System.out.print(cur + " ");

            for (int nxt : adj.get(cur)) {
                if(p[cur] == nxt) continue;
                q.offer(nxt);
                p[nxt] = cur;
                depth[nxt] = depth[cur] + 1;
            }
        }
    }

    static void dfs(int root) {
        // bfs에서 stack으로만 바꾸면 된다.
        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.print(cur + " ");

            for (int nxt : adj.get(cur)) {
                if(p[cur] == nxt) continue;
                stack.push(nxt);
                p[nxt] = cur;
                depth[nxt] = depth[cur] + 1;
            }
        }
    }
    static void dfsRecursion(int cur) {
        // 부모와 depth 배열 재귀로 채우기
        // 스택 메모리가 1MB로 제한되어 있을 땐 V가 3만 이상이면 1-2-3-4-5-6... 형태의
        // 일자 트리 모양에서 스택 메모리 한계를 넘어설 수 있기에 조심 해야한다.
        System.out.print(cur + " ");

        for (int nxt : adj.get(cur)) {
            if(p[cur] == nxt) continue;
            p[nxt] = cur;
            depth[nxt] = depth[cur] + 1;
            dfs(nxt);
        }
    }

    static void dfsRecur(int cur, int par) {
        // call dfsRecur(1,0)
        // 단순 순회
        System.out.print(cur + " ");

        for (int nxt : adj.get(cur)) {
            if(par == nxt) continue;
            dfsRecur(nxt, cur);
        }
    }
}
