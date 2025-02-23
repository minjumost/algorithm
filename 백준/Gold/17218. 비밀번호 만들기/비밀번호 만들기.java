import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{

		String A = bufferedReader.readLine();
		String B = bufferedReader.readLine();

		int[][] dp = new int[A.length()+1][B.length()+1];

		for(int i=1; i<A.length()+1; i++){
			for(int j=1; j<B.length()+1; j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = A.length();
		int j = B.length();

		while(i > 0 && j > 0){
			if(A.charAt(i-1) == B.charAt(j-1)){
				sb.append(A.charAt(i-1));
				i--;
				j--;
			}
			else{
				if(dp[i][j-1] > dp[i-1][j]){
					j--;
				}
				else{
					i--;
				}
			}
		}

		System.out.println(sb.reverse());

	}
}