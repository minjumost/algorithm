import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;
    static int M;

    static int one = Integer.MAX_VALUE;
    static int many = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            many = Math.min(many, Integer.parseInt(stringTokenizer.nextToken()));
            one = Math.min(one, Integer.parseInt(stringTokenizer.nextToken()));
        }
        

        int answer = one * N;
        // 남더라도 패키지 하나 더 사는경우
        answer = Math.min(answer, (N/6 + 1)*many);
        // 갯수 딱 맞춰 사는 경우
        answer = Math.min(answer, (N/6) * many + (N%6) * one);

        System.out.println(answer);

    }


}