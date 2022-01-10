import java.util.*;

import org.omg.CORBA.Current;
public class AssassinManager {
    // YOUR CODE GOES HERE
	AssassinNode front;
	AssassinNode deadFront;
	
	public AssassinManager(ArrayList<String> n) {
		try {
//			AssassinNode front = new AssassinNode(n.get(0));
//			AssassinNode current = front;
//			for(int i = 1; i < n.size(); i++) {
//				current.next = new AssassinNode(n.get(i));
//				current = current.next;
//			}
//			current.next = front;
			for(String s : n) {
				addLast(s);
			}
		}
		catch(Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public String killRing() {
		if(isGameOver()) return front.name + " has won the game!";
		String s = "";
		AssassinNode current = front;
		while(current.next != null) {
			s += current.name + " is stalking " + current.next.name + "\n";
			current = current.next;
		}
		s += current.name + " is stalking " + front.name;
		return s;
	}
	
	public boolean isGameOver() {
		if(front.next == null)
			return true;
		return false;
	}
	
	//methods to add/remove/find
 	public void addLast( String val ){
   		if(front == null) {
   			front = new AssassinNode(val, null);
   			return;
   		}
   		AssassinNode current = front;
   		while(current.next != null) {
   			current = current.next;
   		}
   		current.next = new AssassinNode(val, null);
   		
   	}
 	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("tim");
		names.add("kim");
		names.add("jim");
		names.add("bim");
		names.add("pim");
		AssassinManager test = new AssassinManager(names);
		System.out.println(test.killRing());
	}


}
