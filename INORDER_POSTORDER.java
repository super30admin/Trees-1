// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0)
            return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx =0;
        for(int i = 0;i<inorder.length;i++){
            if(rootVal == inorder[i]){
                idx=i;
                break;
            }
        }
        int[] ileft=Arrays.copyOfRange(inorder,0,idx);
        int[] pleft=Arrays.copyOfRange(preorder,1,ileft.length+1);
        int[] pright=Arrays.copyOfRange(preorder,ileft.length+1,preorder.length);
        int[] iright=Arrays.copyOfRange(inorder,idx+1,inorder.length);
       root.left = buildTree(pleft,ileft);
       root.right = buildTree(pright,iright);
        return root;
    }
}