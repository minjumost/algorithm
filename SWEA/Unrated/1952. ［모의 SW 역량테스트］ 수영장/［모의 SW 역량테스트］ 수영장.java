import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int day;
    static int month;
    static int threeMonth;
    static int year;
    static int[] plan;
    static int[] dp;
 
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for(int t=1; t<=T; t++){
            System.out.printf("#%d %d\n", t, solution());
        }
    }
 
    static int solution() throws IOException {
        // initialize
        plan = new int[13];
        dp = new int[13];
 
        // 가격정보 initialize
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        day = Integer.parseInt(stringTokenizer.nextToken());
        month = Integer.parseInt(stringTokenizer.nextToken());
        threeMonth = Integer.parseInt(stringTokenizer.nextToken());
        year = Integer.parseInt(stringTokenizer.nextToken());
 
 
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<=12; i++){
            int plan = Integer.parseInt(stringTokenizer.nextToken()); // 한 달의 계획 일수
            dp[i] = Math.min(plan * day, month) + dp[i-1]; // 1일권과 1달권 중 작은 값을 선택하고 이전 값에 더해줌.
 
            if(i > 2){ // 3달권을 고려할 수 있는 경우
                dp[i] = Math.min(dp[i], dp[i-3] + threeMonth); // 3달권을 사용한 것과, 사용하지 않은 것 중에 작은값 사용
            }
        }
 
        return Math.min(dp[12], year);
    }
}