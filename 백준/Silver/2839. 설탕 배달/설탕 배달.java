import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int answer;

	static void solution() throws Exception {
		N = Integer.parseInt(bufferedReader.readLine());

		while (N % 5 != 0 && N >= 3) {

			N -= 3;
			answer++;
		}

		while (N / 5 > 0) {
			N -= 5;
			answer++;
		}

		if (N > 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void main(String[] args) throws Exception {

		solution();
	}

}