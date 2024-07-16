import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t=0; t<n; t++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int progress = Integer.parseInt(input[1]);

            int answer = start + progress;
            if(answer >= 24){
                answer -= 24;
            }

            System.out.printf("#%d %d\n", t+1, answer);
        }
    }
}
