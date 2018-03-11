package LinkedList;

public class LLSwappingNodes {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLSwappingNodes obj = new LLSwappingNodes();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node newHead = obj.swapNodes(head, 1, 6);
		while(newHead!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}
//123456
	Node swapNodes(Node root,int i,int j) {
		Node head = root;
		Node first=null,second=null,prev=null;
		Node firstPrev=null,secondPrev=null;
		while(head!=null) {
			// finding first element
			if(head.data==i) {
				first = head;
				firstPrev = prev;
			}
			
			// finding second element
			// finding first element
			if(head.data==j) {
				second = head;
				secondPrev = prev;
			}
			prev = head;
			head = head.next;
		}
		
		//if none or one value is not found
		if (first==null || second == null) {
			return null;
		}
		
		//
		Node temp;
		temp = first.next;
		first.next = second.next;
		second.next = temp;
		
		if (firstPrev!=null){
		firstPrev.next = second;}else {
			root = second;
		}
		if (secondPrev!=null) {
		secondPrev.next = first;}else {
			root = first;
		}
		return root;
	}
	
}
