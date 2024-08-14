import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static StringBuilder stringBuilder;
	static int N;
	static int M;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		stringBuilder = new StringBuilder();
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		visited = new boolean[N + 1];

		permutation(0, new int[M]);
		System.out.println(stringBuilder);
	}

	static void permutation(int depth, int[] temp) {
		if (depth >= M) {
			for (int num : temp) {
				stringBuilder.append(num).append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = depth == 0 ? 1 : temp[depth - 1] + 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			temp[depth] = i;
			permutation(depth + 1, temp);
			visited[i] = false;
		}
	}

}