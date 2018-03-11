package LinkedList;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedArray obj = new MergeTwoSortedArray();
		
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(5);
		head.next.next.next = new Node(7);
		head.next.next.next.next = new Node(9);
		
		Node head2 = new Node(2);
		head2.next = new Node(4);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(8);
		head2.next.next.next.next = new Node(10);
		head2.next.next.next.next.next = new Node(12);

		
		Node newHead = obj.mergeTwoLists(head, head2);
		while(newHead!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}
	
	Node mergeTwoLists(Node first,Node second) {
		Node f = first;
		Node s = second;
		Node ans = null,head = null;
		//Starting point
		if (f.data<s.data) {
			head = f;
			f = f.next;
		}else {
			head = s;
			s = s.next;
		}
		ans = head;
		//For further checks
		while(f!=null && s!=null) {
			if (f.data<s.data) {
				ans.next = f;
				f = f.next;
			}else {
				ans.next=s;
				s = s.next;
			}
			ans = ans.next;
			
		}
		
		//Checking for left over of first list
		while(f!=null) {
			ans.next = f;
			f = f.next;
			ans = ans.next;
		}
		
		//Checking for left over of second list
		while(s!=null) {
			ans.next = s;
			s = s.next;
			ans = ans.next;
		}
	
		return head;
	}

}
