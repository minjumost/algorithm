import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer stringTokenizer;
	private static StringBuilder sb = new StringBuilder();

	private static int n;
	private static int m;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		visited = new boolean[n + 1];
		permutation(0, new int[m]);
		System.out.println(sb);
	}

	// nPm의 결과를 반환합니다.
	static void permutation(int depth, int[] temp) {

		if (depth >= m) {
			for (int number : temp) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			temp[depth] = i;
			permutation(depth + 1, temp);
			visited[i] = false;
		}

		return;
	}

}