import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;

	static int n;
	static int k;
	static int[] kit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		k = Integer.parseInt(stringTokenizer.nextToken());

		kit = new int[n];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			kit[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		boolean[] visited = new boolean[n + 1];
		permutation(0, new int[n], visited);
		System.out.println(answer);
	}

	static void permutation(int length, int[] kits, boolean[] visited) {
		if (length >= n) {
			int strength = 500;
			for (int kit : kits) {
				strength += (kit - k);
				if (strength < 500) {
					return;
				}
			}

			answer += 1;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			kits[length] = kit[i - 1];
			permutation(length + 1, kits, visited);
			visited[i] = false;
		}
	}

}