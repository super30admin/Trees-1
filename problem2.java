// Time Complexity : O(n*n) //for each recursive call we do a for loop
// Space Complexity : O(n*n) // because we are creating a copy of every preorder and inorder array at each step
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

class Solution {
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int rootVal=preorder[0];
        TreeNode root= new TreeNode(rootVal);
        int idx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal)
                idx=i;
        }
        
        int [] inleft = Arrays.copyOfRange(inorder, 0, idx);
        int [] preleft = Arrays.copyOfRange(preorder, 1, inleft.length+1);
        int [] inright = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int [] preright = Arrays.copyOfRange(preorder, inleft.length+1, preorder.length);
            
        root.left=buildTree(preleft, inleft);
        root.right=buildTree(preright, inright);
        return root;
    }
}