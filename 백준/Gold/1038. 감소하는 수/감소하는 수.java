import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static List<Long> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(bufferedReader.readLine());

        if(N < 10){
            System.out.println(N);
            return;
        }
        else if(N >= 1023){
            System.out.println(-1);
            return;
        }
        for(int i=0; i<10; i++){
            search(1, i);
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(N));
    }

    static void search(int idx, long acc){
        if(idx > 10){
            return;
        }
        numbers.add(acc);
        for(int i=0; i<acc % 10; i++){
            search(idx + 1, acc * 10 + i);
        }
    }
}