public class BuilBST {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i=0;
        for(int num: inorder){
            map.put(num, i++);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    
    // TC is O(n)
    // SC is O(h)
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(end< start) return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        // left
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);
        return root;
    }
}
