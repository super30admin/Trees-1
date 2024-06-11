//time O(n)
//space O(n)

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if(start > end) return null;
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx+1, end);
        return root;
    }
}

