import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static String tree;
	static int X;
	static int Y;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bufferedReader.readLine());
		tree = bufferedReader.readLine();
		String[] split = bufferedReader.readLine().split(" ");
		X = Integer.parseInt(split[0]) -1;
		Y = Integer.parseInt(split[1]) -1;

		List<Node> nodes = new ArrayList<>();
		Stack<Node> stack = new Stack<>();

		Node nodeX = null;
		Node nodeY = null;

		int depth = 0;

		for(int i=0; i<N*2; i++){
			if(tree.charAt(i) == '0') {
				stack.push(new Node(i));
				depth ++;
			}
			else{
				Node node = stack.pop();
				node.setEnd(i);
				node.setDepth(depth);
				if(!stack.isEmpty()){
					node.setParent(stack.peek());
				}
				nodes.add(node);
				depth --;
			}
		}

		for(Node node: nodes){
			if(node.equals(X)){
				nodeX = node;
			}
			if(node.equals(Y)){
				nodeY = node;
			}
		}

		while(nodeX.depth != nodeY.depth){
			if(nodeX.depth > nodeY.depth){
				nodeX = nodeX.parent;
			}
			else{
				nodeY = nodeY.parent;
			}
		}

		while(nodeX != nodeY){
			nodeX = nodeX.parent;
			nodeY = nodeY.parent;
		}

		System.out.println((nodeX.start + 1) + " " + (nodeX.end + 1));

	}

	static class Node{
		int start;
		int end;
		int depth;
		Node parent;

		public Node(int start){
			this.start = start;
		}

		public void setEnd(int end){
			this.end = end;
		}

		public void setDepth(int depth){
			this.depth = depth;
		}

		public void setParent(Node parent){
			this.parent = parent;
		}

		public boolean equals(int index){
			return start == index || end == index;
		}
	}


}