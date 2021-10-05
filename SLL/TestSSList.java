// Dev: Miko Nunez

// This is my final output. I have not shared 
// this final code to anyone else
// the code i shared was only meant to "guide" my classmates
// since i noticed that they were having trouble.
// However, the code I shared is not ready for submission, as 
// I have already explicitly warned them.

package SLL;

public class TestSSList {
    public static void main(String[] args) {
        SLList list = new SLList();

        list.addLast(1);
        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);


        System.out.println("Printing list contents...");
        list.printAll();
        System.out.println();

        System.out.println("The first element is: " + list.getFirst());
        System.out.println("The last element is: " + list.getLast());
        System.out.println("Last index of 1 is: " + list.lastIndexOf(1));
        System.out.println("First index of 7 is: " + list.firstIndexOf(7));
        System.out.println("First index of 1 is: " + list.firstIndexOf(1));
        System.out.println("Current list size: " + list.size());

        System.out.println("Deleting last element...");
        list.deleteLast();
        System.out.println("Printing list contents...");
        list.printAll();
        System.out.println("Current list size: " + list.size());

        System.out.println("Deleting last element...");
        list.deleteLast();
        System.out.println("Printing list contents...");
        list.printAll();
        System.out.println("Current list size: " + list.size());
        

        System.out.println("Deleting ALL elements with value of 1...");
        list.deleteAll(1);
        System.out.println("Current list size: " + list.size());
        System.out.println("Printing list contents...");
        list.printAll();
    }
}