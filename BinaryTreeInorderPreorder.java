// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

//iterative approach

class Solution {
   
    int i;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();
        for(int i = 0 ; i <  inorder.length ;i++){
            map.put(inorder[i],i);
        }
       
        return helper(inorder,preorder,0,inorder.length-1);
        
    }
    
    private TreeNode helper(int[] inorder, int[] preorder ,int start ,int end){
   
         if(start > end || i >= inorder.length)
            return null;
         int  index = map.get(preorder[i]);
         i++;
         TreeNode root = new TreeNode(inorder[index]);
         root.left = helper(inorder,preorder,start,index -1);
         root.right = helper(inorder,preorder,index+1,end);
         return root;
    }
}
