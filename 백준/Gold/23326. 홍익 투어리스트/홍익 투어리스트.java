import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, Q;
	static int current = 0;  // 0-based index
	static TreeSet<Integer> sightseeing = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("1")) sightseeing.add(i);
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				one(x);
			} else if (command == 2) {
				int x = Integer.parseInt(st.nextToken());
				two(x);
			} else if (command == 3) {
				three();
			}
		}
	}

	static void one(int idx) {
		if (sightseeing.contains(idx)) {
			sightseeing.remove(idx);
		} else {
			sightseeing.add(idx);
		}
	}

	static void two(int x) {
		current = (current + x) % N;
	}

	static void three() {
		if (sightseeing.isEmpty()) {
			System.out.println(-1);
			return;
		}

		Integer next = sightseeing.ceiling(current);
		if (next != null) {
			System.out.println(next - current);
		} else {
			next = sightseeing.first();
			System.out.println((N - current) + next);
		}
	}
}