
//****VALIDATE BINARY SEARCH TREE- RECURSIVE SOLUTION***
//Time complexity:o(n);
//Space complexity:o(h);
//LeetCode runnable:Y
//Any doubts:N

class Solution {
    boolean flag=true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
        
        
    }
    private void inorder(TreeNode root)
    {
        //Base case
        if(root==null)
        {
            return;
        }
        
        //Logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            flag=false;
        }
        prev=root;
        if(flag)
        {
            inorder(root.right);
        }
    }
}
//****VALIDATE BINARY SEARCH TREE- ITERATIVE SOLUTION***
//Time complexity:o(n);
//Space complexity:o(h);

class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        Stack<TreeNode> st=new Stack<>();
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
        
    }
}


//****VALIDATE BINARY SEARCH TREE- MIN MAX SOLUTION***
//Time complexity:o(n);
//Space complexity:o(h);
//LeetCode runnable:Y
//Any doubts:N

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
        
        
        
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        //BASE:
        if(root==null)
        {
            return true;
        }
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        
        
        //LOGIC:
        boolean left=helper(root.left, min, root.val);
        
        boolean right=helper(root.right, root.val, max);
        
        return left && right; 
        
    }
}

//****CONSTRUCT BINARY TREE FROM PREORDER AND INORDER- Bruteforce solution****
//Time complexity: o(n)square;
//Space complexity: o(n)square;
//Leetcode runnable: Y;



//****CONSTRUCT BINARY TREE FROM PREORDER AND INORDER-optimal solution****
//Time complexity: o(n);
//Space complexity: o(n);
//Leetcode runnable: Y;

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
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        if(preorder.length==0) return null;
        map=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
        
        
    }
    private TreeNode helper(int[] preorder, int start, int end)
    {
        
        //Base
        if(start>end) return null;
        
        //logic
        int rootval=preorder[idx];
        TreeNode root=new TreeNode(rootval);
        idx++;
        //idx of cuurent root in inorder array
        int rootidx=map.get(rootval);
        root.left= helper(preorder, start, rootidx-1);
        root.right=helper(preorder,rootidx+1, end);
        return root; 
        
    }
}
