import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;

    static int[][] abilities;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        abilities = new int[N][N];
        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                abilities[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        System.out.println(solution());

    }

    static int solution(){
        int answer = Integer.MAX_VALUE;

        for(int i=0; i < (1 << N); i++){
            int count = 0;
            for(int j=0; j<N; j++){
                if((i & (1 << j)) != 0){
                    count++;
                }
            }
            if(count != N/2){
                continue;
            }
            int[] start = new int[N/2];
            int[] link = new int[N/2];
            int startIdx = 0;
            int linkIdx = 0;
            for(int j=0; j<N; j++){
                if((i & (1 << j)) != 0){
                    start[startIdx++] = j;
                }else{
                    link[linkIdx++] = j;
                }
            }
            int startAbility = 0;
            int linkAbility = 0;
            for(int j=0; j<N/2; j++){
                for(int k=0; k<N/2; k++){
                    startAbility += abilities[start[j]][start[k]];
                    linkAbility += abilities[link[j]][link[k]];
                }
            }
            answer = Math.min(answer, Math.abs(startAbility - linkAbility));

        }
        return answer;
    }
}