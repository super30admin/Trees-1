/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//T.C = O(n*n)
//S.C = O(N*N)

class Solution {
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(inorder.length==0)
//         {
//             return null;
//         }
        
        
//         int rootVal = preorder[0];
//         TreeNode root = new TreeNode(rootVal);
//         int rootIndex = -1;
//         for(int i=0;i<inorder.length;i++)
//         {
//             if(inorder[i]==rootVal)
//             {
//                 rootIndex = i;
//                 break;
//             }
//         }
        
//         int[] inorderLeft = Arrays.copyOfRange(inorder,0,rootIndex);
//         int[] inorderRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
//         int[] preorderLeft = Arrays.copyOfRange(preorder,1,rootIndex+1);
//         int[] preorderRight =Arrays.copyOfRange(preorder, rootIndex+1,          preorder.length);
//         root.left = buildTree(preorderLeft,inorderLeft);
//         root.right = buildTree(preorderRight,inorderRight);
//         return root;
        
        
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder, 0 , inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[idx]);
        int rootidx = map.get(preorder[idx]);
        idx++;
        root.left= helper ( preorder , start , rootidx-1);
        root.right = helper(preorder,rootidx+1,end);
        return root;
    }
}