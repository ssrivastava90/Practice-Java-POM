package TreeIterations;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBST {
	
	//http://www.geeksforgeeks.org/print-left-view-binary-tree/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void LevelOrderQueue(Node root) {
		
		if (root==null) {
			return;
		}
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.offer(root);
		while((!q1.isEmpty()||(!q2.isEmpty()))){
			while(!q1.isEmpty()) {
				root = q1.poll();
				System.out.print(root.data + " ");
				
				if (root.left!=null) {
					q2.offer(root.left);
				}
				
				if (root.right!=null) {
					q2.offer(root.right);
				}
			}
			System.out.println();
			while(!q2.isEmpty()) {
				root = q2.poll();
				System.out.print(root.data + " ");
				
				if (root.left!=null) {
					q1.offer(root.left);
				}
				
				if (root.right!=null) {
					q1.offer(root.right);
				}
			}	
			System.out.println();
		}
		
	}
	
}
