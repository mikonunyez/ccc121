package bracket_checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) { // Object constructor that stores type and position
        this.type = type;
        this.position = position;
    }
    
    char type;
    int position;

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> brackets_stack = new Stack<Bracket>(); //Creates a new Stack that stores Bracket objects

        Bracket foo = new Bracket('c', 0); // Bracket object. Temporary data for initialization, will get overridden at a later point in runtime
        
        for (int position = 0; position < text.length(); ++position) { // parses through the input string character by character
            char next = text.charAt(position); // gets the character at the current index 
            
            Bracket br = new Bracket(next, position+1); // Bracket object that stores the current character and its position in input string
            
            if (next == '(' || next == '[' || next == '{') { // Checks if the character is an opening bracket
                /*
                If the character is an opening bracket,
                Push save its current character and position in the string as a Bracket object type
                And push it to the brackets_stack stack
                */
                brackets_stack.push(br);
                foo.type = next;
                foo.position = position+1;
            }
            
            if (next == ')' || next == ']' || next == '}') { // Checks if the character is a closing bracket
                /*
                If the character is a closing bracket,
                Initially checks if the stack is empty.
                If not empty, checks if pairs with the object.type of the latest stack item
                    e.g., '(' and ')' pair. '[' and ']' pair, etc
                If the types pair, pop the stack. 
                If not, push the new character and its position as a Bracket object in the stack
                */

                if (brackets_stack.isEmpty()) { // checks if the stack is empty
                    brackets_stack.push(br); // pushes the current character and its position in the string as a Bracket object type to the stack
                }
                else {
                    foo = brackets_stack.peek(); // grabs the latest stack item without deleting it
                    if (foo.match(next)) brackets_stack.pop(); // checks if the latest stack item pairs with the current character. pops latest stack item if true
                    else brackets_stack.push(br);  // pushes the current character and its position if above is false
                } 

                foo.type = next; 
                foo.position = position+1;
            }
            
        }


        /*
        If the stack is empty, prints "Success"
        Otherwise, output the position where the problem occured. Prioritizes first unmatched closing bracket.
        */
        if (brackets_stack.isEmpty()) System.out.println("Success"); 
        else {
            /*
            Traverses through the items in the stack
            If the current item is a closing bracket, pop it out of the stack and store it in the foo Bracket object
            */
            while (!brackets_stack.isEmpty() && (brackets_stack.peek().type == ')' || brackets_stack.peek().type == ']' || brackets_stack.peek().type == '}')){
                foo = brackets_stack.pop();
            }

            System.out.println(foo.position); 
        }
        
    }
}
