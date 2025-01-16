import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int Q;
    static Map<String, List<Integer>> map = new HashMap<>();
    static long answer = 0L;

    public static void main(String[] args) throws Exception{
        Q = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<Q; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int type = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();

            if(type == 1){
                int k = Integer.parseInt(stringTokenizer.nextToken());

                List<Integer> values = new ArrayList<>();
                for(int j=0; j<k; j++){
                    int value = Integer.parseInt(stringTokenizer.nextToken());
                    values.add(value);
                }

                if(map.containsKey(name)){
                    List<Integer> list = map.get(name);
                    list.addAll(values);
                    list.sort((o1, o2) -> o2 - o1);
                }else{
                    values.sort((o1, o2) -> o2 - o1);
                    map.put(name, values);
                }
            }

            if(type == 2){
                int b = Integer.parseInt(stringTokenizer.nextToken());

                if(map.containsKey(name)){
                    List<Integer> list = map.get(name);
                    for(int j=0; j<b; j++){
                        if(list.isEmpty()){
                            break;
                        }
                        answer += list.get(0);
                        list.remove(0);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}