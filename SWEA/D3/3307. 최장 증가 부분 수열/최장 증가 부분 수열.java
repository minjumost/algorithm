import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;
    static int[] numbers;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for(int t=1; t<=T; t++){
            System.out.printf("#%d %d\n", t, solution());
        }
    }

    static int solution() throws IOException {
        int max = Integer.MIN_VALUE;
        N = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        numbers = new int[N];
        dp = new int[N];
        dp[0] = 1;

        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(numbers[j] < numbers[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

                if(dp[i] == 0){
                    dp[i] = 1;
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}