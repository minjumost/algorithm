import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    static int[][] green = new int[6][4];
    static int[][] blue = new int[6][4];
    static int score = 0;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            // 초록 보드 처리
            play(new Block(t, r, c), green);

            // 파란 보드 처리 (블록 회전 후 처리)
            Block rotatedBlock = new Block(t, r, c);
            //System.out.printf("%d %d %d\n", rotatedBlock.startR, rotatedBlock.startC, rotatedBlock.t);
            rotatedBlock.rotate();
            //System.out.printf("%d %d %d\n", rotatedBlock.startR, rotatedBlock.startC, rotatedBlock.t);
            play(rotatedBlock, blue);
        }

        int totalBlocks = countBlocks(green) + countBlocks(blue);
        System.out.println(score);
        System.out.println(totalBlocks);
    }

    static void play(Block block, int[][] board) {
//        System.out.println("원래 모양");
//        for(int i=0; i<6; i++){
//            for(int j=0; j<4; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        if (block.t == 1) {
            int row = 5;
            for (int i = 0; i < 6; i++) {
                if (board[i][block.startC] == 1) {
                    row = i - 1;
                    break;
                }
            }
            board[row][block.startC] = 1;
        }

        if (block.t == 2) {
            int row = 5;
            for (int i = 0; i < 6; i++) {
                if (board[i][block.startC] == 1 || board[i][block.endC] == 1) {
                    row = i - 1;
                    break;
                }
            }
            board[row][block.startC] = 1;
            board[row][block.endC] = 1;
        }

        if (block.t == 3) {
            int row = 5;
            for (int i = 0; i < 6; i++) {
                if (board[i][block.startC] == 1 || board[i][block.endC] == 1) {
                    row = i - 1;
                    break;
                }
            }
            // 블록을 startR과 endR을 고려하여 정확하게 배치
            board[row][block.startC] = 1;
            board[row - 1][block.startC] = 1;
        }

//        System.out.println("쌓은 모양");
//        for(int i=0; i<6; i++){
//            for(int j=0; j<4; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        clearLines(board);

//        System.out.println("지운 모양");
//        for(int i=0; i<6; i++){
//            for(int j=0; j<4; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        handleSpecialRows(board);

//        System.out.println("스페셜 로우 지운 모양");
//        for(int i=0; i<6; i++){
//            for(int j=0; j<4; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
    }

    static void clearLines(int[][] board) {
        for (int i = 5; i >= 0; i--) {
            boolean full = true;
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    full = false;
                    break;
                }
            }
            if (full) {
                score++;
                for (int k = i; k > 0; k--) {
                    System.arraycopy(board[k - 1], 0, board[k], 0, 4);
                }
                for (int j = 0; j < 4; j++) board[0][j] = 0;
                i++;
            }
        }
    }

    static void handleSpecialRows(int[][] board) {
        int rowsToShift = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 1) {
                    rowsToShift++;
                    break;
                }
            }
        }
        for (int i = 5; i >= rowsToShift; i--) {
            System.arraycopy(board[i - rowsToShift], 0, board[i], 0, 4);
        }
        for (int i = 0; i < rowsToShift; i++) {
            for (int j = 0; j < 4; j++) board[i][j] = 0;
        }
    }

    static int countBlocks(int[][] board) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 1) count++;
            }
        }
        return count;
    }

    static class Block {
        int t, startR, startC, endR, endC;

        public Block(int t, int r, int c) {
            this.t = t;

            if (t == 1) {
                startR = r;
                startC = c;
                endR = r;
                endC = c;
            }
            if (t == 2) {
                startR = r;
                startC = c;
                endR = r;
                endC = c + 1;
            }
            if (t == 3) {
                startR = r;
                startC = c;
                endR = r + 1;
                endC = c;
            }
        }

        public void rotate() {
            if( t == 1){
                t = 1;
                startR = startC;
                startC = 3 - endR;
                endR = startR;
                endC = startC;
            }
            else if (t == 2) {
                t = 3;
                int temp = startR;
                startR = startC;
                startC = 3 - temp;
                endR = startR + 1;
                endC = startC;
            } else if (t == 3) {
                t = 2;
                int temp = startR;
                startR = startC;
                startC = 3 - temp - 1;
                endR = startR;
                endC = startC + 1;
            }
        }
    }
}