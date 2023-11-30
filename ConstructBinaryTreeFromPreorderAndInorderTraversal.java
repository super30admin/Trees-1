//  Time Complexity: O(n)
//  Space Complexity: O(n) 
class Solution {
    int preindex = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return createTree(preorder, 0, inorder.length-1);        
    }
    
    public TreeNode createTree(int[] preorder, int instart, int inend){
        if(instart > inend) return null;
        TreeNode tnode = new TreeNode(preorder[preindex++]);
        if(instart == inend) return tnode;
        int inindex = map.get(tnode.val);
        tnode.left = createTree(preorder, instart, inindex -1);
        tnode.right = createTree(preorder, inindex + 1, inend);
        return tnode;
    }
}