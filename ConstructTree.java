// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int idx;
    HashMap<Integer,Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<Integer,Integer>();
        if(preorder == null || inorder == null || preorder.length ==0|| inorder.length == 0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }
    TreeNode helper(int[] preorder,int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
            
        TreeNode cur = new TreeNode(preorder[idx++]);
        int curIdx = hm.get(cur.val);
        cur.left = helper(preorder,inorder,start,curIdx-1);
        cur.right = helper(preorder,inorder,curIdx+1,end);
        return cur;
    }
}