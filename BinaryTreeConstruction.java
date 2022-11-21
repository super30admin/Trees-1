//time complexity is O(N)
//space complexity is O(N)
class Solution {
    int index=0;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return helper(preorder,0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        int temp=preorder[index];
        index=index+1;
        TreeNode root = new TreeNode(temp);
        root.left= helper(preorder, left, hm.get(temp)-1);
        root.right = helper(preorder, hm.get(temp)+1, right);
        return root;

    }
}