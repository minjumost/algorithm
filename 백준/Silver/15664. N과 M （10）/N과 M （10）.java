import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int N;
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static Set<String> answers = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        stringTokenizer = new StringTokenizer((bufferedReader.readLine()));

        N = Integer.parseInt((stringTokenizer.nextToken()));
        M = Integer.parseInt((stringTokenizer.nextToken()));

        numbers = new int[N];
        visited = new boolean[N];

        stringTokenizer = new StringTokenizer((bufferedReader.readLine()));

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt((stringTokenizer.nextToken()));
        }

        Arrays.sort(numbers);

        permutation(0, new int[M]);
    }

    static void permutation(int depth, int[] res) {
        if (depth == M) {
            boolean isAnswer = true;
            for (int i = 0; i < M - 1; i++) {
                if (res[i] > res[i + 1]) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                String answer = "";
                for (int i = 0; i < M; i++) {
                    answer += res[i] + " ";
                }
                if (!answers.contains(answer)) {
                    answers.add(answer);
                    System.out.println(answer);
                }
            }
            return;
        }

        for (int i = 0; i < N; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            res[depth] = numbers[i];
            permutation(depth + 1, res);
            visited[i] = false;
        }

    }
}