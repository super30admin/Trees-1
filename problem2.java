//Construct Binary Tree from Preorder and Inorder Traversal
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    int index = 0;
    HashMap<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length== 0) return null;

        index = 0;

        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start>end || index<0) return null;

        int inorderIdx = map.get(preorder[index++]);
        TreeNode root = new TreeNode(inorder[inorderIdx]);

        root.left = helper(preorder,inorder,start,inorderIdx-1);
        root.right = helper(preorder,inorder,inorderIdx+1,end);
        return root; 
    }
}
