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
		try {
			AssassinNode current = first;
			while(current.next != first) {
				if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
				current = current.next;
			}
			return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public String graveyard() {
		String s = "";
		if(deadFirst == null) return "Nobody's died yet";
		AssassinNode current = deadFirst;
		while(current.next != null) {
			if(killRingContains(current.killer)) {
				s += current.name + " was killed by " + current.killer + "\n";
			}
			current = current.next;
		}
		return s;
		
	}
	
	public boolean graveyardContains(String name) {
		try {
			AssassinNode current = deadFirst;
			while(current.next != null) {
				if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
				current = current.next;
			}
			if(current.name.toLowerCase().equals(name.toLowerCase())) return true;
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
	public void kill(String n) {
		if(isGameOver()) throw new IllegalStateException();
		if(!killRingContains(n)) throw new IllegalArgumentException();
		AssassinNode current2;
   		AssassinNode current = first;
   		AssassinNode previous;
   		while(current.next != first) {
	   			current = current.next;
	   		}
   		AssassinNode last = current.next;
   		//if first one is to be killed
   		if(current.name.toLowerCase().equals(n.toLowerCase())) {
   			deadFirst = current;
   			current2 = deadFirst;
   			current.killer = last.name;
   			first = current.next;
   			return;
   		}
   		//this skips the first node, but we will make a different case for it
   		while(current.next!= null) {
   			previous = current;
   			current = current.next;
   			if(current.name.toLowerCase().equals(n.toLowerCase())) {
   				//checks to see whether people are dead or not to see if it should set the initial node;
   				if(deadFirst == null) {
   					deadFirst = current;
   				}
   				//otherwise it adds current to the graveyard list
   				else {
   					current2  = deadFirst;
   					while(current2.next != null) {
   						current2 = current2.next;
   					}
   					current2.next = current;
   				}
   				//changes current to make sure killring skips it
   				current.killer = previous.name;
   				previous.next = current.next;
   				return;
   			}
   			
   		}
   		
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