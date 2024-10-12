import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;
	static int X;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for(int t=1; t<=T; t++){
			System.out.printf("#%d %d\n", t, solution());
		}


	}

	static int solution() throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		X = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[N][N];
		for(int i=0; i<N; i++){
			int[] line = new int[N];
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for(int j=0; j<N; j++){
				line[j] = Integer.parseInt(stringTokenizer.nextToken());
			}
			map[i] = line;
		}

		int answer = 0;
		for(int i=0; i<N; i++){
			if(can(map[i])){
				answer ++;
			}

			int[] line = new int[N];
			for(int j=0; j<N; j++){
				line[j] = map[j][i];
			}
			if(can(line)){
				answer ++;
			}
		}



		return answer;
	}

	static boolean can(int[] road){
		int cnt = 1;
		int before = road[0];
		for(int i=1; i<road.length; i++){

			if(before < road[i]){
				if(road[i] - before > 1){
					return false;
				}
				else{
					if(cnt >= X){
						cnt = 1;
					}else{
						return false;
					}
				}

			}
			else if(before > road[i]){
				if(before - road[i] > 1){
					return false;
				}
				else{
					if(i + X > road.length){
						return false;
					}
					else{
						for(int j=i; j<i+X; j++){
							if(road[j] != road[i]){
								return false;
							}
							cnt = -X + 1;
						}
					}
				}
			}
			else {
				cnt ++;
			}
			before = road[i];
		}
		return true;
	}

}