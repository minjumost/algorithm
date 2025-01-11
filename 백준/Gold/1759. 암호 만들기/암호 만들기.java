import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int L;
    static int C;

    static char[] alphabets;

    public static void main(String[] args) throws Exception{
        String[] input = bufferedReader.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        alphabets = new char[C];


        input = bufferedReader.readLine().split(" ");
        for(int i=0; i<C; i++){
            alphabets[i] = input[i].charAt(0);
        }

        Arrays.sort(alphabets);
        dfs(0, 0, "");



    }

    static void dfs(int idx, int count, String password) {
        if (count == L) {
            if (isValid(password)) {
                System.out.println(password);
            }
            return;

        }

        if (idx == C) {
            return;
        }

        dfs(idx + 1, count + 1, password + alphabets[idx]);
        dfs(idx + 1, count, password);


    }

    static boolean isValid(String password) {
        int vowel = 0;
        int consonant = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}