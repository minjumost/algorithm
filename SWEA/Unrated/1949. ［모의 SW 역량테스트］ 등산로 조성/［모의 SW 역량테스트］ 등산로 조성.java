import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder stringBuilder;

	static int N;
	static int K;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static boolean[][] visited;
	static int maxLength;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for(int t = 1; t <= T; t++){
			stringBuilder = new StringBuilder();
			stringBuilder.append("#").append(t).append(" ").append(solution()).append("\n");
			bufferedWriter.append(stringBuilder);
		}
		bufferedWriter.close();
	}

	static int solution() throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		int maxHeight =0;
		for(int i=0; i<N; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		maxLength = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j] == maxHeight){
					visited[i][j] = true;
					dfs(i, j, 1, false);
					visited[i][j] = false;
				}
			}
		}
		return maxLength;
	}

	static void dfs(int r, int c, int length, boolean digged){

		for(int i=0; i<4; i++){
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]){
				continue;
			}

			if(map[nr][nc] < map[r][c]){
				visited[nr][nc] = true;
				dfs(nr, nc, length + 1, digged);
				visited[nr][nc] = false;
			}

			else if(!digged && map[nr][nc] - K < map[r][c]){
				int temp = map[nr][nc];
				map[nr][nc] = map[r][c] -1;
				visited[nr][nc] = true;
				digged = true;
				dfs(nr, nc, length+1, digged);
				digged = false;
				visited[nr][nc] = false;
				map[nr][nc] = temp;
			}
		}

		maxLength = Math.max(maxLength, length);
	}
}