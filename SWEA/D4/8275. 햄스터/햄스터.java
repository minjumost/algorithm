import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static StringBuilder stringBuilder = new StringBuilder();
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int X;
	static int M;
	static int[][] history;
	static int[] answer;
	static int maxSum;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int t = 0; t < T; t++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			N = Integer.parseInt(stringTokenizer.nextToken());
			X = Integer.parseInt(stringTokenizer.nextToken());
			M = Integer.parseInt(stringTokenizer.nextToken());
			answer = new int[N];
			history = new int[M][];
			visited = new boolean[M];
			maxSum = -1;

			for (int i = 0; i < M; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				history[i] = new int[] {
					Integer.parseInt(stringTokenizer.nextToken()),
					Integer.parseInt(stringTokenizer.nextToken()),
					Integer.parseInt(stringTokenizer.nextToken())
				};

			}

			solution(0, new int[N]);

			System.out.printf("#%d ", t + 1);
			if (maxSum == -1) {
				System.out.println(-1);
			} else {
				for (int a : answer) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
		}

	}

	static void solution(int length, int[] temp) {
		if (length >= N) {
			for (int[] h : history) {
				int sum = 0;
				for (int i = h[0] - 1; i < h[1]; i++) {
					sum += temp[i];
				}
				if (sum != h[2]) {
					return;
				}
			}

			int sum = 0;
			for (int t : temp) {
				sum += t;
			}
			if (maxSum < sum) {
				maxSum = sum;
				answer = temp.clone();
			}
			return;
		}

		for (int i = 0; i <= X; i++) {
			temp[length] = i;
			solution(length + 1, temp);
		}
	}

}