import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        
        for(int i=0; i<9; i++){
            numbers.add(Integer.parseInt(br.readLine()));   
        }
        int max = Collections.max(numbers);
        System.out.println(max);
        System.out.println(numbers.indexOf(max)+1);
    }
}