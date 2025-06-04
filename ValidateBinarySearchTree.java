//Time Complexity: O(number of nodes)
//Space Complexity: O(height of the tree)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Non conditional void based recursion

class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
        
    }
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);

    }
}

//Conditional void based recursion

class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null || !flag) //add condition in base condition. 2nd Option to reduce right recursive calls when left subtree is not valid
            return;

        //logic
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            flag = false;
            //return; // this will have zero impact, this will not terminate the recusion. All the nodes will be printed.
        }
        System.out.println(root.val);
        prev = root;
       // if(flag){    //conditional recursion. 1st Option: This will save some right recursive calls if we breach at some point. ex. prev >= root
            inorder(root.right);
      //  }
        

    }
}

//Non conditional boolean based recursion
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root){
        //base
        if(root == null)
            return true;
        //logic
        inorder(root.left)
        if(prev!= null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return inorder(root.right);

    }
}

//Conditional boolean based recursion
class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        // Base case
        if (root == null)
            return true;
         //logic       
        if (!inorder(root.left)) // this will stop right recursion if left path is not valid
            return false;

       
        if (prev != null && prev.val >= root.val)
            return false;
        prev = root;

        return inorder(root.right);
    }
}

