// Time Complexity : O(N) as we will have to go through all N nodes max.
// Space Complexity : O(1) as we are not creating any auxillary space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really.

public class ValidBST {
    public class Node {
        int data;
        Node left;
        Node right;
    }

    // return true if the given tree is a BST, else return false
    boolean isBST(Node head){
        return isValidBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isValidBST(Node head, int min, int max) {
        if(head == null || (head.left == null && head.right == null)) {
            return true;
        }

        if((head.left != null && (head.left.data >= head.data || head.left.data <= min)) ||
           (head.right != null && ( head.right.data <= head.data || head.right.data >= max)))   {
               return false;
        }
        
        return isValidBST(head.left, min, head.data) && isValidBST(head.right, head.data, max);
    }
}