import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        String[] input = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        int answer = 0;
        while(Integer.bitCount(N) > K){
            N++;
            answer++;
        }
        System.out.println(answer);
    }
}