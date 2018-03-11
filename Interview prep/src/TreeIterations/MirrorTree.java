package TreeIterations;

public class MirrorTree {
	
	Node mirrorBinarySearchTree(Node root) {
		if (root==null) {
			return null;
		}
		
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorBinarySearchTree(root.left);
		mirrorBinarySearchTree(root.right);
		
		return root;
	}
	
	void printTree(Node root) {
		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
	}
	
	public static void main(String args[]){
		
		Node root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(6);
		
		MirrorTree obj = new MirrorTree();
		root = obj.mirrorBinarySearchTree(root);
		obj.printTree(root);
	}
	
}
