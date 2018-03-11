package LinkedList;

public class DeleteingNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteingNode obj = new DeleteingNode();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node newHead = obj.deleteNode(head, 9);
		
		while(newHead!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}

	Node deleteNode(Node root,int dat) {
		
		Node prev= null;
		Node head = root;
		
		// When first occurrence is the key we need
		if (root.data ==dat) {
			return root.next;
		}
		
		// When any occurrence after the first is key
		while(root!=null) {
			if(root.data==dat) {
				prev.next = root.next; 
				return head;
			}
			prev = root;
			root = root.next;
		}
		
		// When last key is the needed occurrence
		
		return head;
	}
	
}

