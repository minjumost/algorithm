import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int K;
    static int[] coins;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        dp = new int[K + 1];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());    
        }

        dp[0] = 1;
        for(int i=0; i< N; i++){
            for(int j=1; j<=K; j++){
                if(j>=coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        System.out.println(dp[K]);

        
        
    }
}