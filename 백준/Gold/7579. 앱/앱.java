import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;
    static int M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());


        int answer = Integer.MAX_VALUE;
        int[] mem = new int[N];
        int[] cost = new int[N];

        int totalCost = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int i=0;
        while(stringTokenizer.hasMoreTokens()){
            mem[i++] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        i = 0;
        while(stringTokenizer.hasMoreTokens()){
            cost[i] = Integer.parseInt(stringTokenizer.nextToken());
            totalCost += cost[i++];
        }

        dp = new int[N+1][totalCost+1];

        for(i=1; i<=N; i++){
            for(int j=0; j<=totalCost; j++){
                int m = mem[i-1];
                int c = cost[i-1];

                if(j < c){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-c] + m, dp[i-1][j]);
                }

                if(dp[i][j] >= M){
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }

}