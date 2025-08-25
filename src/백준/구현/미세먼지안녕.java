package 백준.구현;        // 17144 - 미세먼지 안녕!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
    static int T, N, M;
    static int[][] board = new int[55][55];
    static int cleanR = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1 && cleanR == -1) {
                    cleanR = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            move();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] > 0) sum += board[i][j];
            }
        }

        System.out.println(sum);
    }

    static void spread() {
        List<Data> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= 5) {
                    list.add(new Data(i, j, board[i][j]));
                }
            }
        }

        for (Data d : list) {

            int x = d.x;
            int y = d.y;
            int v = d.v;

            int cnt = 0;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(board[nx][ny] == -1) continue;

                board[nx][ny] += v / 5;
                cnt++;
            }

            board[x][y] -= v/5 * cnt;
        }
    }

    static void move() {

        // 위 반시계
        for (int i = cleanR - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }

        for (int i = 0; i < M - 1; i++) {
            board[0][i] = board[0][i + 1];
        }
        for (int i = 0; i < cleanR; i++) {
            board[i][M - 1] = board[i + 1][M - 1];
        }
        for (int i = M - 1; i > 1; i--) {
            board[cleanR][i] = board[cleanR][i - 1];
        }
        board[cleanR][1] = 0;

        // 아래 시계
        for (int i = cleanR + 2; i < N - 1; i++) {
            board[i][0] = board[i + 1][0];
        }
        for (int i = 0; i < M - 1; i++) {
            board[N - 1][i] = board[N - 1][i + 1];
        }
        for (int i = N - 1; i > cleanR + 1; i--) {
            board[i][M - 1] = board[i - 1][M - 1];
        }
        for (int i = M - 1; i > 1; i--) {
            board[cleanR + 1][i] = board[cleanR + 1][i - 1];
        }
        board[cleanR+1][1] = 0;
    }

    static class Data{
        int x,y, v;

        Data(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}
