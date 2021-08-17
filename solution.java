//TC=O(n)
//SC=O(n)

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
class Solution {
    boolean isValid= true;
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        Inorder(root);
        return isValid;
        
    }
    public void Inorder(TreeNode root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            isValid=false;
        }
        prev=root;
        Inorder(root.right);
    }
}


//TC=O(n)
//SC=O(n)
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
class Solution {
    HashMap<Integer,Integer> hash=new HashMap<>();
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }
        for(int i=0;i<preorder.length;i++){
            hash.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1);
        
    }
    public TreeNode helper(int[] preorder,int[] inorder,int start,int end){
        // base
        if(start>end){
            return null;
        }
        //logic
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=helper(preorder,inorder,start,hash.get(root.val)-1);
        root.right=helper(preorder,inorder,hash.get(root.val)+1,end);
        return root;
    }
}