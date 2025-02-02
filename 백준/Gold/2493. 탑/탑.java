import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static Tower[] towers;
	static Stack<Tower> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		towers = new Tower[N];

		for(int i=0; i<N; i++){
			int num = Integer.parseInt(stringTokenizer.nextToken());
			towers[i] = new Tower(i + 1, num);
		}

		for(int i=0; i<N; i++){
			while(!stack.isEmpty()){
				if(stack.peek().height > towers[i].height){
					System.out.print(stack.peek().index + " ");
					stack.push(towers[i]);
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()){
				stack.push(towers[i]);
				System.out.print("0 ");
			}

		}

	}

	static class Tower{
		int index;
		int height;

		public Tower(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
}