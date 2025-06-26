import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static int K;

	public static void main(String[] args) throws Exception{
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());

		Jewel[] jewels = new Jewel[N];

		for(int i=0; i<N; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int m = Integer.parseInt(stringTokenizer.nextToken());
			int v = Integer.parseInt(stringTokenizer.nextToken());

			jewels[i] = new Jewel(m, v);
		}

		Arrays.sort(jewels, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.weight == o2.weight) {
					return o2.value - o1.value;
				}
				return o1.weight - o2.weight;
			}
		});

		int[] bags = new int[K];

		for(int i=0; i<K; i++){
			bags[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Arrays.sort(bags);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;

		for(int i=0, j=0; i<K; i++){
			while(j<N && jewels[j].weight <= bags[i]) {
				pq.offer(jewels[j].value);
				j++;
			}

			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}

	static class Jewel {
		int weight;
		int value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}


}