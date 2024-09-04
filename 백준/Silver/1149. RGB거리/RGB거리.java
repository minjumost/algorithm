import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());
		int[][] dp = new int[N+1][3];

		for(int i=1; i<N+1; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int r = Integer.parseInt(stringTokenizer.nextToken());
			int g = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());

			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;

		}

		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

	}
}