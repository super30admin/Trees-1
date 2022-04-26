// much efficient solution
// O(N) TC AND O(N) SC we used hashmap 
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
             // we using value as key because we need index
            map.put(inorder[i], i);
        }
      return helper(preorder, 0, preorder.length - 1);  
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if(start > end) {
            return null;
        }
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
}