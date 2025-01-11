import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int N;
    static List<Ingredient> ingredients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int sour = Integer.parseInt(stringTokenizer.nextToken());
            int acerbity = Integer.parseInt(stringTokenizer.nextToken());

            ingredients.add(new Ingredient(sour, acerbity));
        }

        System.out.println(solution());
    }

    static int solution() {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < (1 << N); i++) {

            int sour = 1;
            int acerbity = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    Ingredient ingredient = ingredients.get(j);
                    acerbity += ingredient.acerbity;
                    sour *= ingredient.sour;
                }
            }

            if (sour != 1 && acerbity != 0) {
                res = Math.min(res, Math.abs(sour - acerbity));
            }

        }

        return res;
    }

    static class Ingredient {
        private int sour;
        private int acerbity;

        public Ingredient(int sour, int acerbity) {
            this.sour = sour;
            this.acerbity = acerbity;
        }


    }
}
