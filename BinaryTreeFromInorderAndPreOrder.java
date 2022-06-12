//Time: O(N^2) | Space: O(N^2)
// Brute force
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 ) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIdx = -1;
        // finding the indx at inorder for the curr root
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == rootVal) {
                inorderRootIdx = i;
                break;
            }
        }
        // preparing values for next iteration
        int[] inLeft = Arrays.copyOfRange(inorder, 0, inorderRootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, inorderRootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1,inorderRootIdx+1);
        int[] preRight = Arrays.copyOfRange(preorder, inorderRootIdx+1, preorder.length);
        // exploring left subtree
        root.left = buildTree(preLeft, inLeft);
        // exploring right subtree
        root.right = buildTree(preRight, inRight);
        return root;
    }
}

// Time:O(N) | Space: O(N)
// Efficient soln using hashMap on inorder
// Traversing the preorder, finding its left and subtrees on inorder, adding the root to the result
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex= 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return builder(preorder, inorder, 0, preorder.length-1);
    }

    private TreeNode builder(int[] preorder, int start, int end) {
        if(start > end) return null;
        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        int rootValIndx = map.get(rootVal);
        root.left = builder(preorder,start,rootValIndx-1);
        root.right = builder(preorder, rootValIndx+1, end);
        return root;
    }
}