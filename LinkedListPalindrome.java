import java.util.*;

public class LinkedListPalindrome
{
    public static void main(String[] args) {
        LinkedList<Integer> n = new LinkedList(Arrays.asList(7, 1, 6, 9, 8, 8, 9, 6, 1, 7));

        ListIterator<Integer> niterator = n.listIterator();
        Iterator<Integer> miterator = n.descendingIterator();
        
        boolean palindrom = true;
        
        for (int i = 0; i < n.size()/2; i++) {
            if (niterator.next() != miterator.next()) {
                palindrom = false;
                break;
            }
        }
        
        System.out.println(palindrom);
    }
}
