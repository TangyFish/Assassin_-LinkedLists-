package Assassin;
public class AssassinNode 
 {
     public final String name;  // this person's name
     public String killer;      // name of who killed this person (null if alive)
     public AssassinNode next;  // next node in the list (null if none)
     
     /**
      * Constructs a new node to store the given name and no next node.
      */
     public AssassinNode(String name) {
         this(name, null);
     }

     /**
      * Constructs a new node to store the given name and a reference
      * to the given next node.
      */
     public AssassinNode(String name, AssassinNode next) {
         this.name = name;
         this.killer = null;
         this.next = next;
     }
 }
