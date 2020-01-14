// time : O(n)
// space :O(n)
// passed all testcases
class Solution {
    int pre_idx=0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map=new HashMap<>();
    // creating map to find index of root in inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        int idx=0;
        for(Integer val:inorder)
        {
            map.put(val,idx++);
        }
        return helper(0,inorder.length);
    }
    // taking root from preorder and subtrees from inorder
    public TreeNode helper(int left,int right)
    {
        if(left==right) return null;
        int root_val=preorder[pre_idx];
        TreeNode root=new TreeNode(root_val);
        int index=map.get(root_val);
        pre_idx++;
        root.left=helper(left,index);
        root.right=helper(index+1,right);
        return root;
    }
}