package x14;    // 2461 - 대표 선수 (PQ 풀이)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 대표선수_PQ {
    static int N, M;

    static class Student {
        int ability;
        int classNum;
        int index;

        Student(int ability, int classNum, int index) {
            this.ability = ability;
            this.classNum = classNum;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] classes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(classes[i]);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.ability));

        int max = 0;
        for (int i = 0; i < N; i++) {
            pq.offer(new Student(classes[i][0], i, 0));
            max = Math.max(max, classes[i][0]);
        }

        int ans = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Student minStudent = pq.poll();
            int min = minStudent.ability;

            ans = Math.min(ans, max - min);

            if (minStudent.index + 1 < M) {
                int nxtIndex = minStudent.index + 1;
                int nxtAbility = classes[minStudent.classNum][nxtIndex];

                pq.offer(new Student(nxtAbility, minStudent.classNum, nxtIndex));
                max = Math.max(max, nxtAbility);
            }else{
                break;
            }
        }

        System.out.println(ans);
    }
}
