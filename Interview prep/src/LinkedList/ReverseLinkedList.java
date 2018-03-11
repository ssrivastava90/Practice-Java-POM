package LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next = new Node(4);
		
		ReverseLinkedList obj = new ReverseLinkedList();
		obj.reverseLinkedList(root);
	}

	
	void reverseLinkedList(Node root) {
		Node prev = null;
		Node next = null;
		Node current = root;
		
		while(root.next!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;			
		}
		
		root = prev;
		
		while(root.next!=null){
			System.out.println(root.data);
			root = root.next;
		}
	}
	
	
}
