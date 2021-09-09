//Time complexity: O(N); n - number of nodes
//Space complexity: O(H), H - height of the tree

//From the pre-order array, we know that first element is the root. 
//We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
//Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. 
//Recursively, we can build up the tree.
class TreeNode {
         int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;    
    }   
}
public class build {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) { //initial check
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //taking the first value from preorder array, since the first value is the root.
        //creating a root node 
        TreeNode root = new TreeNode(preorder[preStart]);
        int cnt = 0;
        for(int i = inStart; i <= inEnd && inorder[i] != root.val; i++) {
            cnt++;
        }
        //performing recursive calls for left and right
        root.left = helper(preorder, inorder, preStart+1, preStart+cnt, inStart, inStart+cnt-1);
        root.right = helper(preorder, inorder, preStart+cnt+1, preEnd, inStart+cnt+1, inEnd);
        return root;
    }
    
}
