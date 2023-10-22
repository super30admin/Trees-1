// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public TreeNode splitTree(int [] preorder,Map<Integer,Integer> map,int pix,int ileft,int iright){
        int rval = preorder[pix];
        int mid = map.get(rval);
        TreeNode root = new TreeNode(rval);
        if(ileft < mid)
            root.left = splitTree(preorder,map,pix+1,ileft,mid-1);
        if(iright > mid)
            root.right = splitTree(preorder,map,pix+1+mid-ileft,mid+1,iright);
            return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        map.put(inorder[i],i);
        return splitTree(preorder,map,0,0,inorder.length-1);
    }
}