//Time Complexity: O(n)
//Space Complexity: O(h) + O(n), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem2_2 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || preorder.length ==0 || inorder == null || inorder.length == 0)
            return null;
        
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        
        if(start > end)
            return null;
        
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = helper(preorder, inorder, start, rootIdx -1);
        root.right = helper(preorder, inorder, rootIdx +1, end);
        
        return root;
    }
}
