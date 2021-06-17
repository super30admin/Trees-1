// 105. Construct Binary Tree from Preorder and Inorder Traversal 

class Solution {
    HashMap<Integer, Integer> map;
    int idx ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;
        map = new HashMap<>();
            for(int i = 0; i < inorder.length; i++)
            {
               map.put(inorder[i], i);
             }
        
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rIdx = map.get(rootVal); 
        root.left = helper(preorder, start, rIdx - 1);
        root.right = helper(preorder, rIdx + 1, end);
        return root;   
        }
         
    }

/*
Complexity analysis

Let N be the length of the input arrays.

Time complexity : O(N).

Space complexity : O(N).

*/
      