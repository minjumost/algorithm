import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int[][] map, dp;
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		M = Integer.parseInt(stringTokenizer.nextToken());
		N = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[M][N];
		for(int i=0; i<M; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		dp = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	static int dfs(int r, int c){
		if(r == M-1 && c == N-1){
			return 1;
		}

		if(dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = 0;

		for(int i=0; i<4; i++){
			int nr= r + dr[i];
			int nc = c + dc[i];

			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;

			if(map[nr][nc] < map[r][c]) {
				dp[r][c] += dfs(nr, nc);

			}
		}

		return dp[r][c];
	}
}