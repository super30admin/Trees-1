// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : problem in keeping track of the index of the preorder array and making the recursive function to build the tree
// Your code here along with comments explaining your approach : hash map to store index of inorder array to get the index of root in O(1) time. Using preorder array to get the root value and then using the index from hash map to divide the inorder array into left and right subtrees. Recursively building the left and right subtrees.
 
class Solution {
    
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        this.idx = 0;
        return helper(preorder, 0, preorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map){
       
        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1, map);
        root.right = helper(preorder, rootIdx + 1, end, map);
        
        return root;
    }
}

