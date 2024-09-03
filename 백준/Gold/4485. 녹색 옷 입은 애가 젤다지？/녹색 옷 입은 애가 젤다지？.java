import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static boolean keep = true;
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		int t = 1;
		while (true) {
			N = Integer.parseInt(bufferedReader.readLine());
			if(N == 0) {
				break;
			}
			System.out.printf("Problem %d: %d\n", t++, solution());
		}
	}

	static int solution() throws IOException {
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}

			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dijkstra();

		return dp[N - 1][N - 1];
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(0, 0, map[0][0]));

		while(!pq.isEmpty()){
			Node node = pq.poll();

			for(int i=0; i<4; i++){
				int nr = node.getR() + dr[i];
				int nc = node.getC() + dc[i];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N){
					continue;
				}

				int cost = node.getCost() + map[nr][nc];

				if(dp[nr][nc] > cost){
					dp[nr][nc] = cost;
					pq.offer(new Node(nr, nc, cost));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		private int r;
		private int c;
		private int cost;

		public Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
		}

		public int getC() {
			return c;
		}

		public int getR() {
			return r;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}