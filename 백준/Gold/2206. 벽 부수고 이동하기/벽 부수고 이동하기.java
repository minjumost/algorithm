import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean[][][] visited;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];
        bfs(0, 0);

        System.out.println(answer);
    }

    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startR, startC, 0, 1});  // 0번째는 r, 1번째는 c, 2번째는 isBroken, 3번째는 거리

        visited[startR][startC][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int isBroken = current[2];
            int steps = current[3];

            if (r == N - 1 && c == M - 1) {
                answer = (answer == -1) ? steps : Math.min(answer, steps);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == 0 && !visited[nr][nc][isBroken]) {
                    visited[nr][nc][isBroken] = true;
                    queue.offer(new int[]{nr, nc, isBroken, steps + 1});
                }

                else if (map[nr][nc] == 1 && isBroken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    queue.offer(new int[]{nr, nc, 1, steps + 1});
                }
            }
        }
    }
}