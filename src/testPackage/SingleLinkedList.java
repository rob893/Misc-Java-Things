package testPackage;

import java.util.Stack;

public class SingleLinkedList 
{
	ListNode head;
	
	
	public SingleLinkedList(ListNode head)
	{
		this.head = head;
	}
	
	public void insertAtHead(int value)
	{
		ListNode newHead = new ListNode(value);
		newHead.next = this.head;
		this.head = newHead;
	}
	
	public boolean contains(int value)
	{
		ListNode curr = this.head;
		
		while(curr != null)
		{
			if(curr.data == value)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static ListNode reverse(ListNode head)
	{
		if(head == null)
		{
			return null;
		}
		
		Stack<ListNode> stack = new Stack<ListNode>();
		
		while(head != null)
		{
			stack.push(head);
			head = head.next;
		}
		
		ListNode newHead = new ListNode(stack.pop().data);
		ListNode curr = newHead;
		
		while(!stack.empty())
		{
			ListNode newNode = new ListNode(stack.pop().data);
			curr.next = newNode;
			curr = curr.next;
		}
		
		return newHead;
	}
	
	public void printList()
	{
		ListNode curr = this.head;
		while(curr != null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public static void printList(ListNode head)
	{
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static SingleLinkedList buildList(int[] values)
	{
		ListNode head = new ListNode(values[0]);
		SingleLinkedList list = new SingleLinkedList(head);
		
		for(int i = 1; i < values.length; i++)
		{
			list.insertAtHead(values[i]);
		}
		
		return list;
	}
}
