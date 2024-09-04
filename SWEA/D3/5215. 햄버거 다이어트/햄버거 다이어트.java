import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static StringBuilder stringBuilder;
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(bufferedReader.readLine());
		for (int t = 1; t <= T; t++) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("#").append(t).append(" ").append(solution()).append("\n");
			bufferedWriter.append(stringBuilder);
		}
		bufferedWriter.close();
	}

	static int solution() throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int L = Integer.parseInt(stringTokenizer.nextToken());
		int[][] ingredients = new int[N + 1][2];
		int[] dp = new int[L + 1];

		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int score = Integer.parseInt(stringTokenizer.nextToken());
			int cal = Integer.parseInt(stringTokenizer.nextToken());

			ingredients[i][0] = score;
			ingredients[i][1] = cal;
		}

		for (int i = 1; i <= N; i++) {
			int score = ingredients[i][0];
			int cal = ingredients[i][1];
			for (int c = L; c >= cal; c--) {
				dp[c] = Math.max(dp[c], dp[c - cal] + score);
			}
		}

		return dp[L];
	}
}