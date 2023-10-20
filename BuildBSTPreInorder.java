// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BuildBSTPreInorder {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();
            int in = inorder.length;
            int pre = preorder.length;

            for(int i = 0; i < in; i++){
                map.put(inorder[i], i);
            }

            return helper(preorder, 0, pre-1, inorder, 0, in-1, map);
        }

        private TreeNode helper(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){

            if(preStart > preEnd || inStart > inEnd )
                return null;

            TreeNode root = new TreeNode(preorder[preStart]);

            int rootInIdx = map.get(root.val);
            int inLeftEls = rootInIdx - inStart;

            root.left = helper(preorder, preStart+1, preStart+inLeftEls, inorder, inStart, rootInIdx-1, map);

            root.right = helper(preorder, preStart+inLeftEls+1, preEnd, inorder, rootInIdx+1, inEnd, map);

            return root;
        }
    }
}
