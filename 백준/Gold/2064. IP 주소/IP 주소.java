import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());
        String[][] ip = new String[N][4];
        StringBuilder network = new StringBuilder();
        StringBuilder subnet = new StringBuilder();

        for(int i=0; i<N; i++){
            ip[i] = bufferedReader.readLine().split("\\.");
        }

        boolean flag = false;
        for(int i=0; i<4; i++){
            int min = Integer.parseInt(ip[0][i]);
            int max = Integer.parseInt(ip[0][i]);

            for(int j=1; j<N; j++){
                min =  min & Integer.parseInt(ip[j][i]);
                max =  max | Integer.parseInt(ip[j][i]);
            }

            if(!flag){
                network.append(min).append(".");
                subnet.append(255 - (max - min)).append(".");
            }
            else{
                network.append(0).append(".");
                subnet.append(0).append(".");
            }

            if(min != max){
                flag = true;
            }
        }

        System.out.println(network.substring(0, network.length()-1));
        System.out.println(subnet.substring(0, subnet.length()-1));
    }
}