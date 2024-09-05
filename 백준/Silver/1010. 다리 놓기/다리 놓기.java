import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;

	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for(int t = 1; t<=T ; t++){
			System.out.println(solution());

		}
	}

	static int solution() throws IOException{
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());

		dp = new int[N+1][M+1];

		for(int i=0; i<=M; i++){
			dp[1][i] = i;
		}

		for(int i=2; i<= N; i++){
			for(int j=i; j<=M; j++){
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
			}
		}

		return dp[N][M];
	}

}