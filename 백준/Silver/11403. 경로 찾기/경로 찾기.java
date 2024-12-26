import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] graph;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());

        graph = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = bufferedReader.readLine().split(" ");

            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int k =0; k< N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(graph[i][k] == 1&& graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}