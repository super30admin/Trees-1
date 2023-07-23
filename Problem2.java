//105. Construct Binary Tree from Preorder and Inorder Traversal

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || inorder.length == 0) return null;
        map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return recurse(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode recurse(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = recurse(preorder, inorder, start, rootIdx - 1);
        root.right = recurse(preorder, inorder, rootIdx + 1, end);
        
        return root;
    }
}

// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder == null || inorder == null ||  inorder.length == 0) return null;
//         int rootVal = preorder[0];
//         int rootIdx = 0;
//         TreeNode root = new TreeNode(rootVal);
//         for(int i = 0; i < inorder.length; i++){
//             if(inorder[i] == rootVal){
//                 System.out.println(rootIdx);
//                 rootIdx = i;
//                 System.out.println(rootIdx);
//                 break;
//             }
//         }
//         int[] inorderLeft = Arrays.copyOfRange(inorder, 0 , rootIdx);
//         int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1 , inorder.length);
        
//         int[] preorderLeft = Arrays.copyOfRange(preorder, 0 , rootIdx);
//         int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1 , preorder.length);
        
//         root.left = buildTree(preorderLeft, inorderLeft);
//         root.right = buildTree(preorderRight, inorderRight);
        
//         return root;
//     }
// }