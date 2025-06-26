import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static int M;
	static List<Integer>[] list;
	static int[] wv;


	public static void main(String[] args) throws Exception {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());

		list = new ArrayList[N + 1];
		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=1; i<N+1; i++){
			int parent = Integer.parseInt(stringTokenizer.nextToken());
			if(parent != -1){
				list[parent].add(i);
			}
		}

		wv = new int[N + 1];
		for(int i=0; i<M; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int man = Integer.parseInt(stringTokenizer.nextToken());
			int w = Integer.parseInt(stringTokenizer.nextToken());
			wv[man] += w;
		}

		dfs(1);
		for(int i=1; i<N+1; i++){
			System.out.print(wv[i] + " ");
		}
	}

	static void dfs(int idx){
		for(int nxt: list[idx]){
			wv[nxt] += wv[idx];
			dfs(nxt);
		}
	}
}