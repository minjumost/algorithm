import java.util.*;

public class Main{
    
    public int solution(int n, String[] in, String[] out){
        int answer = 0;
        
        for(int i=1; i<n; i++){
            List<String> front = new ArrayList<>();
            
            for(int j=0; j<i; j++){
                front.add(in[j]);
            }
            for(int k=0; k <Arrays.asList(out).indexOf(in[i]); k++){
                if(front.contains(out[k])){
                    front.remove(out[k]);
                }
            }
            if(front.size() > 0){
                answer ++;
            }
            
        }
        return answer;
    }
    
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] in = new String[n];
        String[] out = new String[n];
        
        for(int i=0; i< n; i++){
            in[i] = sc.next();   
        }
        for(int i=0; i< n; i++){
            out[i] = sc.next();
        }
        
        System.out.println(T.solution(n, in, out));
    }
}