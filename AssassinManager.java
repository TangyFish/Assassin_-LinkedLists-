package Assassin;
import java.util.*;
import java.awt.List;

public class AssassinManager {
    // YOUR CODE GOES HERE

	AssassinNode first;
	AssassinNode deadFirst;

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
	
	public void kill(String name) {
		try {
			
			return;
		}
		catch(Exception e) {
			throw new IllegalStateException();
		}
		throw new IllegalArgumentException();
	}
	
	
	public boolean isGameOver() {
		if (first.next == null) 
			return true;
		return false;
	}
	
	public String graveYard() {	
		String print = "";
		
		return print;
	}
	public static void main(String[] args) {
		ArrayList<String> bob = new ArrayList<String>(Arrays.asList("Don Knuth","bob","tim","Big John"));
		AssassinManager tim = new AssassinManager(bob);
		System.out.println(tim.killRing());
		
	}
}
