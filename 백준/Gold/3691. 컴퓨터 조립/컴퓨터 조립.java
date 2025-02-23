import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int T;
	static int N;
	static long budget;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(bufferedReader.readLine());

		for(int t=0; t<T; t++){
			solution();
		}
	}

	static void solution() throws Exception{
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		budget = Long.parseLong(stringTokenizer.nextToken());

		Map<String, PriorityQueue<Product>> map = new HashMap<>();

		for(int i=0; i<N; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String type = stringTokenizer.nextToken();
			String name = stringTokenizer.nextToken();
			long price = Long.parseLong(stringTokenizer.nextToken());
			long quality = Long.parseLong(stringTokenizer.nextToken());

			if(!map.containsKey(type)){
				map.put(type, new PriorityQueue<>((a, b) -> {
					if(a.price == b.price){
						return Long.compare(b.quality, a.quality);
					}
					return Long.compare(a.price, b.price);
				}));
			}

			map.get(type).add(new Product(type, name, price, quality));

		}

		PriorityQueue<Product> selected = new PriorityQueue<>(Comparator.comparingLong(a -> a.quality));
		long price = 0;
		long quality = Long.MAX_VALUE;

		for(String type: map.keySet()){
			Product product = map.get(type).poll();
			price += product.price;
			quality = Math.min(quality, product.quality);
			selected.add(product);
		}

		long result = 0;

		while (true){
			Product cur = selected.poll();
			Product next = null;

			boolean canChange = false;

			while(true){
				if(map.get(cur.type).isEmpty()){
					break;
				}

				next = map.get(cur.type).poll();
				if(cur.quality >= next.quality){
					continue;
				}

				if(price - cur.price + next.price > budget){
					break;
				}

				canChange = true;
				break;
			}

			if(canChange){
				price = price - cur.price + next.price;
				selected.add(next);
			}
			else{
				result = cur.quality;
				break;
			}
		}
		System.out.println(result);
	}


	static class Product{
		String type;
		String name;
		long price;
		long quality;

		public Product(String type, String name, long price, long quality) {
			this.type = type;
			this.name = name;
			this.price = price;
			this.quality = quality;
		}
	}
}