import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] buttons;
    static int res, N, M;

    public static void main(String[] args) throws Exception{
        // 목표 채널 N과 고장난 버튼의 개수 M
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        buttons = new boolean[10];  // 고장난 버튼 정보 (false: 고장 안남, true: 고장)
        res = Math.abs(N - 100);  // 기본적으로 +, -만 이용하는 경우

        if(M != 0){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            // 고장난 버튼을 true로 설정
            for(int i = 0; i < M; i++){
                buttons[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 숫자 버튼을 눌러서 목표 채널로 가는 방법을 고려
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean possible = true;

            // i 숫자가 고장난 버튼을 포함하는지 확인
            for (int j = 0; j < str.length(); j++) {
                if (buttons[str.charAt(j) - '0']) {
                    possible = false;
                    break;
                }
            }

            // 고장난 버튼이 포함되지 않으면, 해당 채널로 갈 수 있음
            if (possible) {
                res = Math.min(res, Math.abs(i - N) + str.length());
            }
        }

        System.out.println(res);
    }
}