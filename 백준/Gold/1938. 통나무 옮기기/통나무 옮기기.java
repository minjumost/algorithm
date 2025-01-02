import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());
        map = new char[N][N];

        List<Position> logs = new ArrayList<>();
        List<Position> ends = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = bufferedReader.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'B'){
                    logs.add(new Position(i, j));
                }

                if(map[i][j] == 'E'){
                    ends.add(new Position(i, j));
                }
            }
        }

        Positions log = new Positions(logs);
        Positions end = new Positions(ends);

        System.out.println(bfs(log, end));
    }

    static int bfs(Positions log, Positions end){
        Queue<Map<Positions, Integer>> queue = new ArrayDeque<>();
        List<Positions> visited = new ArrayList<>();

        Map<Positions, Integer> start = new HashMap<>();
        start.put(log, 0);

        queue.add(start);
        visited.add(log);

        while(!queue.isEmpty()){
            Map<Positions, Integer> cur = queue.poll();

            Positions curLog = cur.keySet().iterator().next();

            //System.out.printf("r:%d c:%d direction:%d\n", curLog.centerR, curLog.centerC, curLog.direction);
            int depth = cur.get(curLog);

            if(curLog.equals(end)){
                return depth;

            }

            // 상화좌우 이동
            for(int i=0; i<4; i++){
                int nr = curLog.centerR + dr[i];
                int nc = curLog.centerC + dc[i];
                Positions nextLog = new Positions(nr, nc, curLog.direction);

                if(canMove(nr, nc, curLog.direction) && !visited.contains(nextLog)){
                    visited.add(nextLog);

                    Map<Positions, Integer> next = new HashMap<>();
                    next.put(nextLog, depth + 1);
                    queue.offer(next);

                }
            }

            // 회전
            int newDirection = 1 - curLog.direction;
            Positions nextLog = new Positions(curLog.centerR, curLog.centerC, newDirection);
            if(canRotate(curLog.centerR, curLog.centerC) && !visited.contains(nextLog)){
                visited.add(nextLog);

                Map<Positions, Integer> next = new HashMap<>();
                next.put(nextLog, depth + 1);
                queue.offer(next);
            }
        }

        return 0;
    }

    static boolean canMove(int r, int c, int direction) {
        if (r < 0 || r >= N || c < 0 || c >= N) return false;

        if (direction == 0) { // 가로 방향
            return c - 1 >= 0 && c + 1 < N &&
                    map[r][c - 1] != '1' && map[r][c] != '1' && map[r][c + 1] != '1';
        } else { // 세로 방향
            return r - 1 >= 0 && r + 1 < N &&
                    map[r - 1][c] != '1' && map[r][c] != '1' && map[r + 1][c] != '1';
        }
    }

    static boolean canRotate(int r, int c){
        if(r-1 < 0 || r+1 > N-1 || c-1 < 0 || c+1 > N-1){
            return false;
        }


        for(int i = -1; i<2; i++){
            for(int j=-1; j<2; j++){
                if(map[r + i][c + j] == '1'){
                    return false;
                }
            }
        }
        return true;
    }

    static class Positions{
        int centerR;
        int centerC;
        int direction;

        public Positions(List<Position> positions){
            centerR = positions.get(1).r;
            centerC = positions.get(1).c;
            direction = positions.get(0).r == positions.get(1).r ? 0 : 1;
        }

        public Positions(int r, int c, int direction){
            this.centerR = r;
            this.centerC = c;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Positions other = (Positions) obj;
            return centerR == other.centerR && centerC == other.centerC && direction == other.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(centerR, centerC, direction);
        }

    }

    static class Position{
        int r;
        int c;

        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}