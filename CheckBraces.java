import java.util.Stack;
import java.util.Hashtable;

public class CheckBraces {
    public static void main(String args[]) {
        String s = "{([](([])))}";
      
        Hashtable<String, String> braces = new Hashtable<String, String>();
        braces.put("}", "{");
        braces.put(")", "(");
        braces.put("]", "[");
        
        Stack stack = new Stack();
        
        for (int i=0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            String open = braces.get(c);
            
            if (!stack.isEmpty() && open != null && open.equals(stack.peek())) {
                stack.pop();
                System.out.println("Pop: " + open);
            } else {
                stack.push(c);
                System.out.println("Push: " + c);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Matched");
        } else {
            System.out.println("Unmatched");
        }

    }
}