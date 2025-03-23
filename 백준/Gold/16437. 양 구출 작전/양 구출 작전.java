import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static List<Island> islands = new ArrayList<>();
	static int answer = 0;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bufferedReader.readLine());

		for(int i=0; i<=N; i++){
			islands.add(new Island());
		}

		for(int i=2; i<=N; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			char type = stringTokenizer.nextToken().charAt(0);
			int num = Integer.parseInt(stringTokenizer.nextToken());
			int connected = Integer.parseInt(stringTokenizer.nextToken());

			islands.get(i).type = type;
			islands.get(i).num = num;
			islands.get(i).connected.add(connected);
			islands.get(connected).connected.add(i);
		}

		long answer = dfs(1, 0);
		System.out.println(answer);

	}

	static long dfs(int node, int parent) {
		long totalSheep = 0;
		
		for (int next : islands.get(node).connected) {
			if (next == parent) continue;
			totalSheep += dfs(next, node);
		}
		
		Island island = islands.get(node);
		if (island.type == 'S') {
			totalSheep += island.num;
		} else if (island.type == 'W') {
			totalSheep -= island.num;
			if (totalSheep < 0) totalSheep = 0;
		}
		
		return totalSheep;
	}



	static class Island{
		char type;
		int num;
		List<Integer> connected = new ArrayList<>();
	}
}