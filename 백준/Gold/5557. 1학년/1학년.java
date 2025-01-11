import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dp;
    static int[] numbers;

    public static void main(String[] args) throws  Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        dp = new long[N][21];
        numbers = new int[N];

        String[] input = bufferedReader.readLine().split(" ");
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        dp[0][numbers[0]] = 1;

        for(int i=1; i<N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j] != 0){
                    if(j + numbers[i] <= 20){
                        dp[i][j + numbers[i]] += dp[i-1][j];
                    }
                    if(j - numbers[i] >= 0){
                        dp[i][j - numbers[i]] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][numbers[N-1]]);
    }
}