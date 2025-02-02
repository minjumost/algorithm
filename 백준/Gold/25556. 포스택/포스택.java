import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
	static int N;
	static int[] numbers;
	static List<Stack<Integer>> stacks = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(bufferedReader.readLine());
		numbers = new int[N];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		for(int i=0; i<N; i++){
			int num = numbers[i];

			boolean isPushed = false;
			for(Stack<Integer> stack: stacks){
				if(stack.peek() < num){
					stack.push(num);
					isPushed = true;
					break;
				}
			}

			if(!isPushed){
				if(stacks.size() == 4){
					System.out.println("NO");
					return;
				}

				else{
					Stack<Integer> stack = new Stack<>();
					stack.push(num);
					stacks.add(stack);
				}
			}
		}

		System.out.println("YES");

	}
}