// TC : O(N): N: length of inorder array
// SC:  O(N): O(2N) -> O(N) for recursive stack + O(N) for hashmap
// Did it run successfully on Leetcode? : Yes
class Solution {
    HashMap<Integer, Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if (inorder.length == 0 || preorder.length == 0) 
           return null;
        map = new HashMap();
        for ( int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length -1);       
   }
   private TreeNode helper(int[] preorder, int start, int end)
   {
       //base
       if ( start > end)
           return null; 

       // logic
       int rootVal = preorder[index];
       index++;
       TreeNode root = new TreeNode(rootVal);
       int root_index = map.get(rootVal);
       root.left = helper(preorder, start, root_index-1);
       root.right = helper(preorder, root_index+1, end);
       return root;
   }
}