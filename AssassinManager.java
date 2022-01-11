import java.util.*;
import java.awt.List;

public class AssassinManager {
    // YOUR CODE GOES HERE

	AssassinNode first;
	AssassinNode deadFirst = null;

	public AssassinManager(ArrayList<String> names) {
		try {
			first = new AssassinNode(names.get(0));
			AssassinNode cur = first;
			for (int i=1;i<names.size();i++) {
				cur.next = new AssassinNode(names.get(i));
				cur = cur.next;
			}
			cur.next = first;
		}
		catch(Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public String killRing() {
		String print = "";
		if (isGameOver()) 
			return first.name + " won the game!";
		AssassinNode cur = first;
		while(cur.next != first) {
			print += cur.name + " is stalking " + cur.next.name + "\n";
			cur = cur.next;
		}
		print += cur.name + " is stalking " + cur.next.name + "\n";
		return print;
	}
	
	public boolean killRingContains(String name) {
		AssassinNode current = first;
		while(current.next != first) {
			if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
			current = current.next;
		}
		return false;
	}
	
	public String graveYard() {
		String s = "";
		if(deadFirst == null) return s;
		AssassinNode current = deadFirst;
		while(current.next != null) {
			if(killRingContains(current.killer)) {
				s += current.name + " was killed by " + current.killer + "\n";
			}
			current = current.next;
		}
		return s;
		
	}
	
	public boolean graveYardContains(String name) {
		AssassinNode current = deadFirst;
		while(current.next != null) {
			if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
			current = current.next;
		}
		if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
		return false;
	}
	
	
	public void kill(String n) {
		AssassinNode current = first;
		AssassinNode current2 = first;
   		AssassinNode previous;
   		if(current.name.equals(n)) {
   			deadFirst = current;
   			while(current2.next != first) {
   				current2 = current2.next;
   			}
   			current.killer = current2.name;
   			first = current.next;
   			return; // no need to reset current since it already returns once the person is killed
   		}
   		//in case the one who's killed isnt first
   		while(current.next != first) {
   			previous = current;
   			current = current.next;
   			if(current.name.equals(n)) {
   				deadFirst = current;
   				previous.next = current.next;
   				current.next = null;
   				return;
   			}
   		
   		}
   		
   		return;
	}
	
	public boolean isGameOver() {
		if (first.next == null) 
			return true;
		return false;
	}
	
	public String winner() {
		return first.name;
	}
	
	public static void main(String[] args) throws Exception{
		ArrayList<String> bob = new ArrayList<String>(Arrays.asList("Don Knuth","bob","tim","Big John"));
		AssassinManager tim = new AssassinManager(bob);
		System.out.println(tim.killRing());
		
	}
}
