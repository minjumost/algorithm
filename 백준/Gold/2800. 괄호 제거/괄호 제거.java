import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<Pair> pairs = new ArrayList<>();
	static boolean[] visited;
	static String input;
	static Set<String> results = new HashSet<>();


	public static void main(String[] args) throws Exception{
		input = bufferedReader.readLine();

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == '('){
				stack.push(i);
			}

			else if(input.charAt(i) == ')'){
				int open = stack.pop();

				Pair pair = new Pair(open, i);
				pairs.add(pair);
			}
		}

		visited = new boolean[pairs.size()];
		subset(0);

		List<String> result = new ArrayList<>(results);
		Collections.sort(result);
		result.remove(0);
		for(String r : result){
			System.out.println(r);
		}
	}

	static void subset(int idx){
		if(idx == pairs.size()){
			StringBuilder sb = new StringBuilder(input);
			List<Integer> deleteList = new ArrayList<>();
			for(int i=0; i<pairs.size(); i++){
				if(!visited[i]){
					Pair pair = pairs.get(i);
					deleteList.add(pair.open);
					deleteList.add(pair.close);
				}
			}
			deleteList.sort(Collections.reverseOrder());

			for(int index : deleteList){
				sb.deleteCharAt(index);
			}

			results.add(sb.toString());
			return;
		}

		visited[idx] = true;
		subset(idx + 1);
		visited[idx] = false;
		subset(idx + 1);
	}

	static class Pair {
		int open;
		int close;

		public Pair(int open, int close){
			this.open = open;
			this.close = close;
		}
	}

}