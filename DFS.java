import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class DFS {
    public static void main(String ... args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        traverseDFS(root);
        //recursiveDFS(root);
    }

    public static void traverseDFS(Node root) {

        Stack<Node> stack = new Stack();
        stack.add(root);

        Node current;
        while (!stack.isEmpty()) {
            current = stack.pop();

            System.out.println(current);

            if (current.right != null) {
                stack.push(current.right);
            }
           
            if (current.left != null) {
                stack.push(current.left);
            }
        }

    }

    public static void recursiveDFS(Node root) {
        if (root == null) return;

        recursiveDFS(root.left);
        recursiveDFS(root.right);
        System.out.println(root.data);

    }
}
