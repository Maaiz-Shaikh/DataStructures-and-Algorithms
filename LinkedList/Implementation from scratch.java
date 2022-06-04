class LL {
    Node head;
    private int size;
    
    LL() {
        this.size = 0;
    }
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            size++;
            this.data = data;
            this.next = null;
        }
    }
    
    // add first
    public void addFirst(int data) {
        
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    // add last
    public void addLast(int data) {
        
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            return;
        }
        
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        
        currNode.next = newNode;
    }
    
    // print Linked List
    public void print() {
        if(head == null) {
            System.out.print("Empty");
            return;
        }
        
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("null");
        
    }
    
    // delete first
    public void deleteFirst() {
        if(head == null) {
            System.out.println("Empty");
            return;
        }
        size--;
        head = head.next;
    }
    
    // delete last
    public void deleteLast() {
        if(head == null) {
            System.out.println("Empty");
            return;
        }
        
        size--;
        if(head.next == null) {
            head = null;
            return;
        }
        
        Node secondLastNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        
        secondLastNode.next = null;
    }
    
    // size
    public int getSize() {
        return size;
    }
}
public class Main{
	public static void main(String[] args) {
		LL list = new LL();
		
		list.addLast(2);
		list.addFirst(1);
		list.print();
		
		list.addLast(3);
		list.addLast(4);
		list.print();
		System.out.println("Size : "+list.getSize());
		
		list.deleteFirst();
		list.print();
		
		list.deleteLast();
		list.print();
		System.out.println("Size : "+list.getSize());
	}
}
