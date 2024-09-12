// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = preorder.length;
        if(n==0)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,n-1,preorder,map);
    }
    
   public TreeNode helper(int min, int max, int[] preorder, Map<Integer,Integer> map){
       if(min>max||index>=preorder.length)return null;
       TreeNode root = null;
       int nodeIndex = map.get(preorder[index]);
       if(nodeIndex<=max && nodeIndex>=min){
           root=new TreeNode(preorder[index]);
           index++;
           root.left = helper(min,nodeIndex-1,preorder,map);
           root.right = helper(nodeIndex+1,max,preorder,map);
       }
       return root;
   }
}