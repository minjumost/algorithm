// 시계 1, 반시계 -1
// N극 0, S극 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for(int t = 1; t <= T; t++){
            System.out.printf("#%d %d\n", t, solution());
        }
    }

    static int solution() throws IOException {
        int answer = 0;
        int k = Integer.parseInt(bufferedReader.readLine());
        int[][] gears = new int[4][8];
        int[][] copy = gears.clone();
        for(int i=0; i<4; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int j=0; j<8; j++){
                gears[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0; i<k; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int gearNum =  Integer.parseInt(stringTokenizer.nextToken());
            int direction = Integer.parseInt(stringTokenizer.nextToken());

            // j는 기어 번호
            // 돌리는 기어번호의 오른쪽 확인
            int cur = -direction;
            for(int j=gearNum; j<4; j++){
                if(gears[j-1][2] != gears[j][6]){
                    copy[j] = shift(gears[j], cur);
                    cur *= -1;
                }else{
                    break;
                }
            }

            cur = -direction;
            for(int j=gearNum-2; j>=0; j--){
                if(gears[j+1][6] != gears[j][2]){
                    copy[j] = shift(gears[j], cur);
                    cur *= -1;
                }else{
                    break;
                }
            }

            copy[gearNum-1] = shift(gears[gearNum-1], direction);
            gears = copy.clone();

        }

        for(int i=0; i<4; i++){
            if(gears[i][0] == 1){
                answer += Math.pow(2, i);
            }
        }
        return answer;
    }

    static int[] shift(int[] arr, int direction){
        // 시계방향이면, 오른쪽으로 쉬프트
        if(direction == 1){
            int[] res = new int[arr.length];
            res[0] = arr[arr.length-1];
            for(int i=1; i<arr.length; i++){
                res[i] = arr[i-1];
            }
            return res;
        }
        // 반시계 방향이면, 왼쪽으로 쉬프트
        else{
            int[] res = new int[arr.length];
            res[arr.length-1] = arr[0];
            for(int i=0; i<arr.length-1; i++){
                res[i] = arr[i+1];
            }
            return res;
        }
    }
}