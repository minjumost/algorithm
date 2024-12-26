import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(bufferedReader.readLine());

        for(int t=0; t<T; t++){
            solution();
        }
    }

    static void solution() throws Exception{
        String coins = "";

        for(int i=0; i<3; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<3; j++){
                char coin = stringTokenizer.nextToken().charAt(0);
                coins += coin;
            }
        }

        System.out.println(bfs(coins));
    }

    static int bfs(String coins) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.add(coins);
        map.put(coins, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int cnt = map.get(cur);

            // 완성되면 바로 리턴
            if(isCompleted(cur)){
                return cnt;
            }

            StringBuilder next = new StringBuilder(cur);
            for(int i=0; i<3; i++){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=3; i<6; i++){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=6; i<9; i++){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=0; i<9; i+=3){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=1; i<9; i+=3){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=2; i<9; i+=3){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=0; i<9; i+=4){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }

            next = new StringBuilder(cur);
            for(int i=2; i<=6; i+=2){
                char coin = next.charAt(i);
                next.deleteCharAt(i);

                if(coin == 'H'){
                    next.insert(i, 'T');
                }
                else{
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1){
                map.put(next.toString(), cnt+1);
                queue.add(next.toString());
            }
        }

        return -1;
    }

    static boolean isCompleted(String coin){
        for(int i=1; i<coin.length(); i++){
            if(coin.charAt(0) != coin.charAt(i)){
                return false;
            }
        }
        return true;
    }
}