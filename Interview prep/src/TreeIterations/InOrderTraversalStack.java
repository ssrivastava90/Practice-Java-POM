package TreeIterations;

import java.util.Stack;

public class InOrderTraversalStack {
// To be used to find Kth largest element as well.
	void traverseInOrder(Node root) {
		if (root==null){
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(true) {
			if(root!= null) {
				st.push(root);
				root = root.left;
			}else {
				if(st.isEmpty()) {
					break;
				}
				root = st.pop();
				System.out.println(root.data);
				root = root.right;
			}
		}	
	}
}
