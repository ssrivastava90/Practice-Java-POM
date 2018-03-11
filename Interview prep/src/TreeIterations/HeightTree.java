package TreeIterations;

public class HeightTree {

	public static void main(String args[]) {
		
		
	}
	
	



public int getHeight(Node root) {
	if (root==null) {
		return 0;
	}
	int leftH = getHeight(root.left);
	int rightH = getHeight(root.right);
	
	return 1+Integer.max(leftH,rightH);
	
}
}