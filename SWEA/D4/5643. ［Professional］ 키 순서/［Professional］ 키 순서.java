import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N, M;
	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for(int t =1; t<=T; t++){
			System.out.printf("#%d %d\n", t, solution());
		}
	}

	static int solution() throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());
		int M = Integer.parseInt(bufferedReader.readLine());

		adjMatrix = new int[N+1][N+1];

		for(int i=0; i<M; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());
			adjMatrix[a][b] = 1;
		}

		for(int k=1; k<=N; k++){
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					if(adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1){
						adjMatrix[i][j] = 1;
					}
				}
			}
		}

		int answer = 0;
		for(int i=1; i<=N; i++){
			int cnt = 0;
			for(int j=1; j<=N; j++){
				if(i == j) continue;
				if(adjMatrix[i][j] == 1 || adjMatrix[j][i] == 1){
					cnt++;
				}
			}
			if(cnt == N-1){
				answer++;
			}
		}
		return answer;
	}
}