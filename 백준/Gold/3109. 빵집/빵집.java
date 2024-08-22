import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int R;
    static int C;
    static char[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());


        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        answer = 0;
        for(int r=0; r<R; r++){
            if(dfs(r,0)){
                answer ++;
            }
        }
        System.out.println(answer);
    }


    static boolean dfs(int r, int c){
        map[r][c] = 'X';

        if(c == C-1){
            return true;
        }

        if(r > 0 && map[r-1][c+1] == '.'){
            if(dfs(r-1, c+1)){
                return true;
            }
        }
        if(map[r][c+1] == '.'){
            if (dfs(r, c+1)){
                return true;
            }
        }
        if(r < R-1 && map[r+1][c+1] == '.'){
            if (dfs(r+1, c+1)){
                return true;
            }
        }
        return false;
    }
}