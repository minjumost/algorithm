import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int R;
    static int C;
    static int T;

    static int[][] map;
    static AirCleaner airCleaner;
    static List<Dust> dusts;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws  Exception{
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[R][C];
        airCleaner = null;
        dusts = new ArrayList<>();

        for(int i=0; i<R; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if(map[i][j] == -1 && airCleaner == null){
                    airCleaner = new AirCleaner(i, j);
                }

                if(map[i][j] > 0){
                    dusts.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        for(int i=0; i<T; i++){
            spreadDust();
            cleanAir();
            getDusts();

        }

        int answer = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] > 0){
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    static void spreadDust(){
        for(Dust dust: dusts){

            for(int i=0; i<4; i++){
                int nr = dust.r + dr[i];
                int nc = dust.c + dc[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1 || map[nr][nc] == -1){
                    continue;
                }

                map[nr][nc] += dust.amount/5;
                map[dust.r][dust.c] -= dust.amount/5;

            }

        }
    }

    static void cleanAir(){
        // 아래쪽 순환
        for(int i= airCleaner.r+2; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }

        for(int i=0; i<C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }

        for(int i=R-1; i> airCleaner.r+1; i--){
            map[i][C-1] = map[i-1][C-1];
        }

        for(int i=C-1; i>1; i--){
            map[airCleaner.r+1][i] = map[airCleaner.r+1][i-1];
        }

        map[airCleaner.r+1][1] = 0;

        // 위쪽 순환
        for(int i= airCleaner.r-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }

        for(int i=0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }

        for(int i=0; i< airCleaner.r; i++){
            map[i][C-1] = map[i+1][C-1];
        }

        for(int i= C-1; i> 1; i--){
            map[airCleaner.r][i] = map[airCleaner.r][i-1];
        }

        map[airCleaner.r][1] = 0;
    }

    static void getDusts(){

        dusts = new ArrayList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] > 0){
                    dusts.add(new Dust(i, j, map[i][j]));
                }
            }
        }
    }

    static class AirCleaner{
        int r, c;

        public AirCleaner(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static class Dust{
        int r, c, amount;

        public Dust(int r, int c, int amount){
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

}