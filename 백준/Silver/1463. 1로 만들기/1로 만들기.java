import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());
		int[] dp = new int[N+1];

		dp[0] = 0;
		dp[1] = 0;

		for(int i = 2; i<= N; i++){
			int min = dp[i-1];
			if(i % 2 == 0){
				min = Math.min(min, dp[i/2]);
			}
			if(i % 3 == 0){
				min = Math.min(min, dp[i/3]);
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[N]);
	}
}