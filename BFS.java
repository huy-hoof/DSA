import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class BFS {
    public static void main(String ... args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);


        traverseBFS(root);
    }

    public static void traverseBFS(Node root) {

        ArrayList<Node> queue = new ArrayList();
        queue.add(root);

        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove(0);
            System.out.println(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

    }
    
}
