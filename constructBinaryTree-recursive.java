//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    Map<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helperMethod(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helperMethod(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[index]);
        int root_index = map.get(preorder[index]);
        index++;
        root.left = helperMethod(preorder, start, root_index - 1);
        root.right = helperMethod(preorder, root_index + 1, end);
        return root;
    }
}