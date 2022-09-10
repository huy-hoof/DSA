import java.io.*;
import java.util.*;

/********************************************************
 * CODE INSTRUCTIONS:                                   *
 * 1) The method findInOrderSuccessor you're asked      *
 *    to implement is located at line 36.               *
 * 2) Use the helper code below to implement it.        *
 * 3) In a nutshell, the helper code allows you to      *
 *    to build a Binary Search Tree.                    *
 * 4) Jump to line 103 to see an example for how the    *
 *    helper code is used to test findInOrderSuccessor. *
 ********************************************************/
/*
DFS

DLR
LDR inorder
LRD

->
5,9,11,12,14,20,25
<-

input
9 -> 11
11 -> 12
14 -> 20


*/

class BSTInorderSuccessor {

  static class Node {
      
    int key;
    Node left;
    Node right;
    Node parent;
    
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }
  
  static class BinarySearchTree {
    
    Node root;
    Stack<Node> preNode = new Stack();
    boolean found = false;

    Node findInOrderSuccessor(Node inputNode) {
      // your code goes here 
      
      Node current;
      if (inputNode.left != null) {     //parent node
        current = inputNode.right;
        while (current.left != null) {
          current = current.left;
        }
        
        return current;
        
      } else if (inputNode.left == null && inputNode == inputNode.parent.left) {    //left child leaf
        return inputNode.parent;
      
      } else if (inputNode.left == null && inputNode == inputNode.parent.right) {    //right child leaf
        if (inputNode.parent.parent == null) {    //right child leaf of the root parent
          return null;  
        }

        current = inputNode.parent;
        while (current.parent != null) {
          current = current.parent;
        }
        return current;
        
      } else {
        return null;      
      }
            
      //inorder(root, inputNode);
      
      //return ((Node) preNode.pop());
     
    }
    
    
    
    
    void inorder(Node root, Node input) {
      System.out.println("found " + found);
      if (root == null || found) {
        return;        
      }

      if (root.key == input.key) {
        found = true;
        return;
      }
     
      inorder(root.right, input);

      System.out.println(root.key + "  ");
      
      
      if (!found) {
        preNode.push(root);
      }

      //if (preNode.peek() != null) {
        //System.out.println("prenode: " + ((Node) preNode.peek()).key);
    //}

      inorder(root.left, input);      

    }
    
    //  Given a binary search tree and a number, inserts a new node
    //  with the given number in the correct place in the tree
    void insert(int key) {
      
      // 1. If the tree is empty, create the root
      if(this.root == null) {
        this.root = new Node(key);
        return;
      }

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
      Node currentNode = this.root;
      Node newNode = new Node(key); 

      while(currentNode != null) {
        if(key < currentNode.key) {
          if(currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if(currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
    
    // Return a reference to a node in the BST by its key.
    // Use this method when you need a node to test your 
    // findInOrderSuccessor method on
    Node getNodeByKey(int key) {
      Node currentNode = this.root;
      
      while(currentNode != null) {
        if(key == currentNode.key) {
          return currentNode;
        }
        
        if(key < currentNode.key) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      
      return null; 
    }
  }
  
  /***********************************************
   * Driver program to test findInOrderSuccessor *
   ***********************************************/

  public static void main(String[] args) {
     
    Node test = null, succ = null;
     
    // Create a Binary Search Tree
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(20);
    tree.insert(9);
    tree.insert(25);
    tree.insert(5);
    tree.insert(12);
    tree.insert(11);
    tree.insert(14);
     
    // Get a reference to the node whose key is 9
    test = tree.getNodeByKey(11);

    // Find the in order successor of test
    succ = tree.findInOrderSuccessor(test);
     
    // Print the key of the successor node
    if (succ != null) {
      System.out.println("Inorder successor of " + test.key +
                          " is " + succ.key);
    } else {
      System.out.println("Inorder successor does not exist");
    }
  }
}