import java.util.*;
import java.lang.*;

public class LinkedListSum
{
    public static void main(String[] args) {
        LinkedList<Integer> n = new LinkedList(Arrays.asList(7, 1, 6, 9, 9));
        LinkedList<Integer> m = new LinkedList(Arrays.asList(5, 9, 2, 0, 5));
        LinkedList<Integer> s = new LinkedList();
        
        int addRememberedOne = 0;
        
        ListIterator<Integer> niterator = n.listIterator();
        ListIterator<Integer> miterator = m.listIterator();
        
        while( niterator.hasNext() || miterator.hasNext() ) {
            int ndigit = (niterator.hasNext()) ? niterator.next() : 0;
            int mdigit = (miterator.hasNext()) ? miterator.next() : 0;

            int sum = ndigit + mdigit + addRememberedOne;
            s.add(sum % 10);
            
            addRememberedOne = (sum >= 10) ? 1 : 0;
        }
        
        if (addRememberedOne == 1) s.add(1);
        
        System.out.println(s);
    }
}
