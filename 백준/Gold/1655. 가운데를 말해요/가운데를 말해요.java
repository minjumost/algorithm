import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Queue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    static Queue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(bufferedReader.readLine());

            if(left.size() == right.size()) {
                left.add(num);

                if(!right.isEmpty() && left.peek() > right.peek()){
                    right.add(left.poll());
                    left.add(right.poll());
                }
            }
            else{
                right.add(num);

                if(left.peek() > right.peek()){
                    right.add(left.poll());
                    left.add(right.poll());
                }
            }

            System.out.println(left.peek());
        }

    }
}