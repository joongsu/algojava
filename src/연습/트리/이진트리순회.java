package 연습.트리;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회 {
    static int[] lc = {0, 2, 4, 6, 0, 0, 0, 0, 0};
    static int[] rc = {0, 3, 5, 7, 0, 8, 0, 0, 0};
    public static void main(String[] args) {

    }

    static void levelOrderTraversal() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // root = 1 , lc[1] = 2 , rc[1] = 3

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            if(lc[cur]!=0) q.offer(lc[cur]);
            if(rc[cur]!=0) q.offer(rc[cur]);
        }
    }

    static void preorderTraversal(int cur) {
        // 현재 정점 방문 -> 왼쪽 서브 트리 전위 순회 -> 오른쪽 서브 트리 순회
        System.out.print(cur + " ");
        if(lc[cur] !=0) preorderTraversal(lc[cur]);
        if(rc[cur] != 0) preorderTraversal(rc[cur]);
        // preorderTraversal(1)
    }

    static void inorderTraversal(int cur) {
        // 왼쪽 서브 트리 전위 순회 -> 현재 정점 방문 -> 오른쪽 서브 트리 순회
        // 중위 순회
        if(lc[cur] != 0) inorderTraversal(lc[cur]);
        System.out.print(cur);
        if(rc[cur] != 0) inorderTraversal(rc[cur]);
    }

    static void postorderTraversal(int cur) {
        // 왼쪽 서브 트리를 후위 순회 -> 오른쪽 서브 트리 순회 -> 현재 정점 방문
        if(lc[cur] != 0) postorderTraversal(lc[cur]);
        if(rc[cur] != 0) postorderTraversal(rc[cur]);
        System.out.print(cur + " ");
    }
}
