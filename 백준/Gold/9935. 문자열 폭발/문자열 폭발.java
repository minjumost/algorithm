import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();

		Stack<Character> st = new Stack<>();

		for(int i=0; i<str.length(); i++) {
			st.push(str.charAt(i)); // 1. 문자를 stack에 넣는다.

			if(st.size()>=target.length()) { // 2. 만약 stack의 size가 target의 길이보다 크거나 같다면
				boolean flag = true;
				for(int j=0; j<target.length(); j++) { // stack에 들어있는 문자들을 target과 같은지 비교한다.
					if(target.charAt(j) != st.get(st.size()-target.length()+j)) {
						flag = false;
						break;
					}
				}
				if(flag) { // 3. 만약 같으면 stack에서 pop()한다.
					for(int k=0; k<target.length(); k++) {
						st.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if(st.isEmpty()) {
			sb.append("FRULA");
		} else {
			for(char c: st) {
				sb.append(c);
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
}