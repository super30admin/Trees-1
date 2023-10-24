import java.util.LinkedList;
import java.util.Queue;

// first approach would be to do an inorder traversal and see that the resulting array is in ascending order
// we can do it recurssion and provide a check such that it returns false, the moment we encounter a breach
// Creating binary tree is taken from GeeksForGeeks
// Time complexity: O(n)
// Space complexity: O(1)

 

public class ValidateTree {


    static class Node {
        int key;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;
    static Node prev;

    static void insert(Node temp, int key)
    {
 
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
    
    public static void main(String[] args)
    {
        int[] array = {5,1,4,3,6};
        Node root = new Node(array[0]);

        for (int i = 1; i < array.length-2; i++)
        {
             insert(root, i);
        }

        System.out.println("The tree is valid : " + isValidTree(root)); 
    }

    public static boolean isValidTree(Node root){

        if(root == null) return true;

        //base
        boolean left = isValidTree(root.left);

        if(prev!= null && prev.key > root.key)
        {
            return false;
        }

        prev = root;
        boolean right = isValidTree(root.right);

        return left && right;
    }

    


}