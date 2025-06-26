import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bufferedReader.readLine());
		numbers = new int[N];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int[] frequency = new int[1000001];
		for(int num : numbers) {
			frequency[num]++;
		}

		int[] nextGreaterFrequency = new int[N];
		int[] stack = new int[N];
		int top = -1;
		for(int i=N-1; i>=0; i--) {
			while(top >= 0 && frequency[numbers[stack[top]]] <= frequency[numbers[i]]) {
				top--;
			}
			if(top < 0) {
				nextGreaterFrequency[i] = -1;
			} else {
				nextGreaterFrequency[i] = stack[top];
			}
			stack[++top] = i;
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			sb.append(nextGreaterFrequency[i] == -1 ? -1 : numbers[nextGreaterFrequency[i]]).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}