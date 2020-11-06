import java.util.Arrays;

/**
 * Time Complexity: O(n^2)
 * Space Complexity : O(1) - no extra space
 * Idea:
 * 1. Get data from preorder to create new node. 
 * 2. search for data in inorder array and left part of inorder array becomes left subtree and right part becomes right subtree
 * 3. return root
 */

class InorderToBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    
    
    public int findInInorder(int data, int[] inorder){

        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == data)
                return i;
        }
        return -1;
    }

    static int preorderIndex=0;
    // int preorderIndex = 0;
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){

        if(inorderStart > inorderEnd)
            return null;
        
        // create node from preorder
        int data = preorder[preorderIndex];
        preorderIndex++;
        TreeNode newNode = new TreeNode(data);

        // no children
        if(inorderStart == inorderEnd) return newNode;
        
        //search in inorder to find index
        int inorderIndex = findInInorder(data, inorder);


        //node.left -> left side in inorder
        newNode.left = buildTreeHelper(preorder, inorder, inorderStart, inorderIndex-1);

        //node.right -> right side in inorder

        newNode.right = buildTreeHelper(preorder, inorder, inorderIndex+1, inorderEnd);

        return newNode;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
                
        TreeNode root = buildTreeHelper(preorder, inorder, 0, inorder.length-1);
        return root;
    }

    /**rev */
   // int preorderIndex = 0;
    public TreeNode helper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){
        
       // if(inorderStart>inorderEnd) return null;
       if(preorder.length == 0) return null;

        //TreeNode newNode = new TreeNode(preorder[preorderIndex]);
        TreeNode newNode = new TreeNode(preorder[0]);
      //  preorderIndex++;
        if(inorderStart == inorderEnd) return newNode;
        System.out.println("Inside " + newNode.val);


        //find
        int inorderIndex = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == newNode.val){
                inorderIndex = i;
            }
        } 
        //= findInInorder(newNode.val, inorder);
        //mod inorder
        int[] newinorderLeft = Arrays.copyOfRange(inorder, 0, inorderIndex);
        int[] newinorderRight = Arrays.copyOfRange(inorder, inorderIndex+1, inorder.length);
        //mod preorder

        int[] newPreorderLeft = Arrays.copyOfRange(preorder, 1, inorderIndex+1);
        int[] newPreorderRight = Arrays.copyOfRange(preorder, inorderIndex+1, preorder.length);
        //left
        newNode.left = helper(newPreorderLeft, newinorderLeft, inorderStart, inorderIndex-1);
        newNode.right = helper(newPreorderRight, newinorderRight, inorderIndex+1, inorderEnd);

        return newNode;
    }

    public TreeNode inpretoBST(int[] preorder, int[] inorder){
        
        return helper(preorder, inorder, 0, inorder.length-1);
        // return null;
    }
   
    /**rev */
    public void printInorderTraversal(TreeNode root){

        if(root == null) return;
        printInorderTraversal(root.left);
        System.out.print(root.val + " ");
        printInorderTraversal(root.right);

    }

    public static void main(String[] args){
        System.out.println("InorderToBST");
        InorderToBST obj = new InorderToBST();
         int[] preorder = {3,9,20,15,7};
         int[] inorder = {9,3,15,20,7};
        // TreeNode root = obj.buildTree(preorder, inorder);
        // obj.printInorderTraversal(root);
        TreeNode root = obj.inpretoBST(preorder, inorder);
        obj.printInorderTraversal(root);
    }
}