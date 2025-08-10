import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int Q;
    // 기존: static int[][] music;
    static List<int[]>[] music; // 각 원소: {to, weight}
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 기존: music = new int[N + 1][N + 1];
        music = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) music[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 기존: music[p][q] = r; music[q][p] = r;
            music[p].add(new int[]{q, r});
            music[q].add(new int[]{p, r});
        }

        for(int i=0; i<Q; i++){
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            boolean[] isRelatived = new boolean[N+1];

            visited[v] = true;
            dfs(v, k, Integer.MAX_VALUE, visited, isRelatived);

            for(boolean r: isRelatived){
                if(r){
                    answer ++;
                }
            }
            System.out.println(answer - 1); // 시작 정점 제외
        }
    }

    /**
     * v = vertex
     * k = 기준
     * r = 유사도(경로의 최솟값)
     * visited = 방문 여부
     * isRelatived = 유사한지(k를 만족하는지)
     */
    static void dfs(int v, int k, int r, boolean[] visited, boolean[] isRelatived){

        if(r >= k){
            isRelatived[v] = true;
        }

        // 기존: for (int i=1; i<=N; i++) { if (music[v][i] > 0 && !visited[i]) ... }
        for (int[] e : music[v]) {
            int i = e[0];
            int w = e[1];
            if (!visited[i]) {
                int nextR = Math.min(r, w);
                // 가지치기: nextR < k면 더 내려가도 최소값이 좋아질 수 없으니 스킵
                if (nextR < k && !isRelatived[v]) {
                    // 현재 v 자체도 k 미만이면 하위 경로 전부 k 미만이므로 생략
                    continue;
                }
                visited[i] = true;
                dfs(i, k, nextR, visited, isRelatived);
                // 트리이므로 백트래킹 불필요: visited[i] = false;  (제거)
            }
        }
    }
}