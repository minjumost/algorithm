import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Stack<String> stack = new Stack<>();
	static String S;

	public static void main(String[] args) throws Exception {
		S = bufferedReader.readLine();

		for(int i=0; i<S.length(); i++){
			if(S.charAt(i) == ')'){
				long count = 0;
				while(!stack.peek().equals("(") ){
					String s = stack.pop();
					if(s.equals("*")){
						count += Integer.parseInt(stack.pop());
					}
					else{
						count ++;
					}
				}
				stack.pop();
				int K = Integer.parseInt(stack.pop());
				count *= K;
				stack.push(count + "");
				stack.push("*");

			}
			else{
				stack.push(S.charAt(i) + "");
			}

		}

		long answer = 0;
		while(!stack.isEmpty()){
			String s = stack.pop();
			if(s.equals("*")){
				answer += Integer.parseInt(stack.pop());
			}
			else{
				answer++;
			}
		}

		System.out.println(answer);

	}
}