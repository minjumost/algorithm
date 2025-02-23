import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String str = bufferedReader.readLine();

		int len = str.length();
		int result = 0;

		for(int i=0; i<len; i++){
			String subStr = str.substring(i, len);
			result = Math.max(result, getMaxSubLength(subStr));
		}

		System.out.println(result);
	}

	static int getMaxSubLength(String str){
		int j=0;
		int n=str.length();
		int max =0;
		int[] pi = new int[n];

		for(int i=1; i<n; i++){
			while(j>0 && str.charAt(i) != str.charAt(j)){
				j = pi[j-1];
			}

			if(str.charAt(i) == str.charAt(j)){
				pi[i] = ++j;
				max = Math.max(max, pi[i]);
			}
		}

		return max;
	}
}