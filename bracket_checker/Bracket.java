package bracket_checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> brackets_stack = new Stack<Bracket>();

        Bracket foo = new Bracket('c', 0);
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            
            Bracket br = new Bracket(next, position+1);
            
            if (next == '(' || next == '[' || next == '{') {
                brackets_stack.push(br);
                foo.type = next;
                foo.position = position+1;
            }
            
            if (next == ')' || next == ']' || next == '}') {
                if (brackets_stack.isEmpty()) {
                    brackets_stack.push(br);
                }
                else {
                    foo = brackets_stack.peek();
                    if (foo.match(next)) brackets_stack.pop();
                    else brackets_stack.push(br); 
                } 
                foo.type = next;
                foo.position = position+1;
            }
            
        }

        if (brackets_stack.isEmpty()) System.out.println("Success");
        else {
            while (!brackets_stack.isEmpty() && (brackets_stack.peek().type == ')' || brackets_stack.peek().type == ']' || brackets_stack.peek().type == '}')){
                foo = brackets_stack.pop();
            }
            System.out.println(foo.position);
        }
        
    }
}
