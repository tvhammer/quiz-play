package leetcodejava;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListNthNode {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode pointer = head;
		ListNode nPlusOne = head;
		int counter = 0;
		
		if (head.next == null && n == 1) {
			return null;
		}
		
		while (pointer.next != null) {
			pointer = pointer.next;
			if (counter >= n ) {
				nPlusOne = nPlusOne.next;
			}
			counter++;
		}
		if(counter < n){
			return head.next;
		} else {
			nPlusOne.next = nPlusOne.next.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		
		var nodes = IntStream.range(1, 6).boxed().map(i -> new ListNode(i)).collect(Collectors.toList());
		for (int i = 0; i < nodes.size() - 1; i++) {
			nodes.get(i).next = nodes.get(i + 1);
		}
		ListNode result = removeNthFromEnd(nodes.get(0), 1);
		System.out.println(result);
		
		nodes = IntStream.range(1, 3).boxed().map(i -> new ListNode(i)).collect(Collectors.toList());
		for (int i = 0; i < nodes.size() - 1; i++) {
			nodes.get(i).next = nodes.get(i + 1);
		}
		result = removeNthFromEnd(nodes.get(0), 2);
		System.out.println(result);
		
		nodes = IntStream.range(1, 4).boxed().map(i -> new ListNode(i)).collect(Collectors.toList());
		for (int i = 0; i < nodes.size() - 1; i++) {
			nodes.get(i).next = nodes.get(i + 1);
		}
		result = removeNthFromEnd(nodes.get(0), 3);
		System.out.println(result);
	}
}


class ListNode {
	int val;
	ListNode next;
	
	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	@Override
	public String toString() {
		
		ListNode pointer = this;
		StringBuffer sb = new StringBuffer("[");
		sb.append(this.val);
		pointer = pointer.next;
		while (pointer != null) {
			sb.append(String.format(",%d", pointer.val));
			pointer = pointer.next;
		}
		sb.append("]");
		return sb.toString();
	}
}