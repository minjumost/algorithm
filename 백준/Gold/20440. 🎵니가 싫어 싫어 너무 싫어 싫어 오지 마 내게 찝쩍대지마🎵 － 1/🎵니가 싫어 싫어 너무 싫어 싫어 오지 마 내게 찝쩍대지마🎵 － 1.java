import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int N;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> o1 - o2);

        int sum = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        boolean isMax = false;

        for(int key: keys){
            sum += map.get(key);

            if(sum > max){
                max = sum;
                start = key;
                isMax = true;
            }

            if(sum < max && isMax){
                end = key;
                isMax = false;
            }
        }

        System.out.println(max);
        System.out.println(start + " " + end);


    }


}