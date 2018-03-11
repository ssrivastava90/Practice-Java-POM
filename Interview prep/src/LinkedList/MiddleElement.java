package LinkedList;

public class MiddleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleElement obj = new MiddleElement();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node newHead = obj.middleNode(head);
		System.out.println(newHead.data);
		}
	
	Node middleNode(Node head) {
		Node slow=head,fast=head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	}
