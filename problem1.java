// ## Problem1 https://leetcode.com/problems/validate-binary-search-tree/

// Time Complexity : O(n)
// Space Complexity : O(h) [height of tree]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// coded with multiple approaches, each approach has a one line description above it.






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


 
// recursive + global flag + global prev

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if( root == null)
        {
            return true;
        }
        prev = null;
        flag = true;
        inorder(root);
        return flag;

    }

    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            flag =false;
        }
        prev= root;
        inorder(root.right);


    }
}


// recursive + global flag + passing prev reference as an array (local variable)

class Solution {
    boolean flag;
    
    public boolean isValidBST(TreeNode root) {
        
        if( root == null)
        {
            return true;
        }
        
        flag = true;
        inorder(root, new TreeNode[1]);
        return flag;

    }

    public void inorder(TreeNode root, TreeNode[] prev)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left, prev);
        if(prev[0]!=null && prev[0].val>=root.val)
        {
            flag =false;
        }
        prev[0]= root;
        inorder(root.right, prev);


    }
}

// recursive + global prev + flag returned locally

class Solution {
    
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if( root == null)
        {
            return true;
        }
        prev = null;
        
        return inorder(root);
        

    }

    public boolean inorder(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        boolean case1=inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            return false;
        }
        prev= root;
        boolean case2=inorder(root.right);
        return case1 && case2;


    }
}




// iterative + global prev 

class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {

        if(root == null)
        {
            return true;
        }

        Stack<TreeNode> s = new Stack<>();

        while(root!=null || !s.isEmpty())
        {
            while(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev!=null && prev.val>= root.val)
            {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
        
    }
}


// recursive without maintaining previous, it depends on the property that the root value should be between a range of values, this range is propogated from the root nodes.


class Solution {
    
    
    public boolean isValidBST(TreeNode root) {
        
        if( root == null)
        {
            return true;
        }
        
        
        return validate(root, null, null);
        

    }

    public boolean validate(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
        {
            return true;
        }

        if((min!=null && root.val<=min) || (max!=null && root.val>=max))
        {
            return false;
        }
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);


        


    }
}

