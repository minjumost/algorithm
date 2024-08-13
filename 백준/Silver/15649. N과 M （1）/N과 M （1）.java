import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer stringTokenizer;
	static int n;
	static int m;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		visited = new boolean[n + 1];
		permutation(n, m, new ArrayList<Integer>());
		bufferedWriter.write(sb.toString());
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	// nPm의 결과를 반환합니다.
	static void permutation(int n, int m, List<Integer> temp) {

		if (temp.size() == m) {
			for (int number : temp) {
				sb.append(number + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			temp.add(i);
			permutation(n, m, temp);
			temp.remove((Object)i);
			visited[i] = false;
		}

		return;
	}

}