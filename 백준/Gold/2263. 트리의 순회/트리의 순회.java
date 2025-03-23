import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stringTokenizer;
	static int N;

	static int[] inorder;
	static int[] postorder;
	static int[] inorderIndex;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bufferedReader.readLine());

		inorder = new int[N+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=1; i<=N; i++){
			inorder[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		postorder = new int[N+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=1; i<=N; i++){
			postorder[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		inorderIndex = new int[N+1];
		for(int i=1; i<=N; i++){
			inorderIndex[inorder[i]] = i;
		}

		preorder(1, N, 1, N);

	}

	static void preorder(int inStart, int inEnd, int postStart, int postEnd){

		if(inStart > inEnd || postStart > postEnd) return;
		int root = postorder[postEnd];

		System.out.print(root + " ");

		int rootIndex = inorderIndex[root];
		int leftLen = rootIndex - inStart;

		preorder(inStart, rootIndex-1, postStart, postStart+ leftLen -1);
		preorder(rootIndex+1, inEnd, postStart + leftLen, postEnd-1);
	}

}