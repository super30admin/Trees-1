//Time Complexity: O(n) — Each node is processed once, and map lookups are O(1).
//Space Complexity: O(n) — HashMap stores n elements and recursion stack takes up to O(n) space in the worst case.

//Use a HashMap to quickly find the index of any node in the inorder array.
//Traverse the preorder array to pick root nodes in order and recursively build the left and right subtrees using index boundaries from the inorder array.
//Increment a global index to move through preorder elements as you construct the tree.


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
        // base case
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