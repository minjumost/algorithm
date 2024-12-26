import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] map;
    static boolean[][] visited, wvisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Location> queue = new ArrayDeque<>();
    static Queue<Location> wqueue = new ArrayDeque<>();


    static int answer = 0;
    static boolean canExit = false;

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        wvisited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String input = bufferedReader.readLine();

            for(int j=0; j<C; j++){
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'S'){
                    queue.add(new Location(i, j));
                }

                if(map[i][j] == '*'){
                    wqueue.add(new Location(i, j));
                }
            }
        }

        bfs();
        System.out.println(canExit ? answer : "KAKTUS");

    }

    static void bfs(){

        while(true){
            answer ++;

            waterMove();

            int size = queue.size();
            if(size == 0){
                break;
            }

            for(int t=0; t<size; t++){
                Location next = queue.poll();

                for(int i=0; i<4; i++){
                    int nr = next.r + dr[i];
                    int nc = next.c + dc[i];

                    if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1 || visited[nr][nc]){
                        continue;
                    }

                    if(map[nr][nc] == 'D'){
                        canExit = true;
                        return;
                    }

                    if(map[nr][nc] == '.' && !wvisited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.add(new Location(nr, nc));
                    }
                }
            }
        }
    }

    static void waterMove() {
        int size = wqueue.size();
        for(int t=0; t<size; t++){
            Location next = wqueue.poll();

            for(int i=0; i<4; i++){
                int nr = next.r + dr[i];
                int nc = next.c + dc[i];

                if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1 || wvisited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == '.'){
                    wvisited[nr][nc] = true;
                    wqueue.add(new Location(nr, nc));
                }
            }
        }
    }


    static class Location{
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}