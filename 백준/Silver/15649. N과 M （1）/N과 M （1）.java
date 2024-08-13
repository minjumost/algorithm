import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, R;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		makePermutation(0, new int[R], new boolean[N]);
		System.out.println(output);
	}

	private static void makePermutation(final int nthChoose, int[] choosed, boolean[] visited) {
		if (nthChoose >= R) {
			for (int num : choosed) {
				output.append(num).append(" ");
			}
			output.append("\n");
			return;
		}
		for (int n = 0; n < N; n++) {
			if (!visited[n]) {
				visited[n] = true;
				choosed[nthChoose] = n + 1;
				makePermutation(nthChoose + 1, choosed, visited);
				visited[n] = false;
			}
		}
	}
}