//time complexity: O(n) where is the length of the inorder array
//space complexity : O(n), calls to all elements are stored in the recursive stack
//executed on leetcode: yes

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length-1);
        
    }
    public TreeNode helper(int[] preorder,int[] inorder,int root_index_preorder,int inorder_start,int inorder_end)
    {   if(root_index_preorder>preorder.length-1 || inorder_start>inorder_end) return null;
     TreeNode root = new TreeNode(preorder[root_index_preorder]);
     //find the index of root node in the inorder array so that we can split the tree based on that index
     int i=0;
     while(inorder[i]!=root.val)
     {
         i++;
     }
     root.left = helper(preorder,inorder,root_index_preorder+1,inorder_start,i-1);
     root.right = helper(preorder,inorder,root_index_preorder+i-inorder_start+1,i+1,inorder_end); 
     return root;
    }
}