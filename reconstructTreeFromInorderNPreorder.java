
 
//time complexity: O(n)
//space complexity:O(n)


import java.util.*;
class TreeSolution {
     class TreeNode {
        int val;
        TreeNode left;
      TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     int n = preorder.length;
        if(preorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++)         //O(n)
            map.put(inorder[i], i);
       return buildTree_dfs(0, n-1,preorder, map);      //O(n)
    }
    
    public TreeNode buildTree_dfs(int min, int max, int[] pre, Map<Integer, Integer> map)
    {
       if(min > max || idx >= pre.length)
           return null;
        TreeNode root = null;
        int loc = map.get(pre[idx]);
        if (loc <= max && loc >= min)
        {
            root = new TreeNode(pre[idx]);
            idx++;
            root.left = buildTree_dfs(min, loc - 1, pre, map);
            root.right = buildTree_dfs(loc + 1, max, pre, map);
            
        }
        return root;
    }
        
}