//105. https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = -1;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val){
                rootIndex = i;
                break;
            }
        }

        //O(2n) collectively
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;

    }
}

//Optimizing Arrays.copyOfRange
//Time Complexity: O(n^2)
//Space Complexity: O(n) -> Only the nodes stored in the map occupy space

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        this.map = new HashMap<>();
        //store inorder array to the map to know the exact index of every node
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start > end){
            return null;
        }

        int rootVal = preorder[idx];
        idx++;
        //get rootIndex from inorder array
        int rootIdx = map.get(rootVal);
        //create root, root.left, root.right
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);

        return root;
    }
}