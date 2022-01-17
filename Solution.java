//Validate BST
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    TreeNode prev;
  
    public boolean isValidBST(TreeNode root) {
      return  helper(root,null,null);
       
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;
        //logic
        // boolean left = helper(root.left,min,root.val);
         if(!left) return false;
        // boolean right = helper(root.right,root.val,max);
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
    
   
}

//-------------------------------------------------------------//
//Construct binary tree from preorder and inorder traversal
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution { 
    HashMap<Integer, Integer> inorderMap; 
    int preIdx; 
    public TreeNode buildTree(int[] preorder, int[] inorder) { 

        if(preorder == null || inorder == null) { 
            return null; 
        }

    inorderMap = new HashMap<>();
    for(int i = 0; i < inorder.length;i++) {
        inorderMap.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0 , inorder.length-1);
}

private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
    if(start > end) {
        return null;
    }

    int rootVal = preorder[preIdx];
    preIdx++;
    TreeNode root = new TreeNode(rootVal);

    int rootIdx = inorderMap.get(rootVal);

    root.left = helper(preorder, inorder, start, rootIdx - 1);
    root.right = helper(preorder, inorder, rootIdx + 1, end);
    return root;
}
}