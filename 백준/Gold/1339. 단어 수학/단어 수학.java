import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr = new int[26];

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            String input = bufferedReader.readLine();
            for(int j=0; j<input.length(); j++){
                char c = input.charAt(j);
                arr[c-'A'] += Math.pow(10, input.length()-j-1);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int answer = 0;
        for(int i=25; i>=0; i--){
            if(arr[i] == 0) break;
            answer += arr[i] * num;
            num--;
        }

        System.out.println(answer);

    }
}