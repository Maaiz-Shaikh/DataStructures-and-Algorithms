import java.util.LinkedList;

public class Main{
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList();
		
    // Adding
		list.addLast(2);
		list.addFirst(1);
		System.out.println(list);
		
		
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
		
     // Printing
		for(int i=0; i<list.size(); i++) {
		    System.out.print(list.get(i)+"->");
		}
		System.out.println("null");
		System.out.println("Size : "+list.size());
		
		
     // Deleting
		list.removeFirst();
		System.out.println(list);
		
		list.removeLast();
		System.out.println(list);
		System.out.println("Size : "+list.size());
	}
}
