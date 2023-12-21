//VOID BASE RECURSION

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    TreeNode prev;
    bool flag;
    
    public bool IsValidBST(TreeNode root) {
        
        this.flag = true;
        helper(root);
        return flag;
    }
    
    public void helper(TreeNode root)
    {
        //base case
        if(root == null) return;
        
        helper(root.left);
        //Console.WriteLine("Up "+root.val);
        if(prev != null && prev.val >= root.val) //found breach
        {
            flag = false;
            return;
        }
        prev = root;
        //Console.WriteLine("prev = root "+root.val);
        
        helper(root.right);
        //Console.WriteLine("DOWN "+root.val);
          
    }
}

//VOID BASE RECURSION WITH OPTIMIZATION IN NUMBER OF CALLS
public class Solution {
    TreeNode prev;
    bool flag;
    
    public bool IsValidBST(TreeNode root) {
        
        this.flag = true;
        helper(root);
        return flag;
    }
    
    public void helper(TreeNode root)
    {
        //base case
        if(root == null) return;
        if(!flag) return;
        //if(flag)
            helper(root.left);
        //Console.WriteLine("Up "+root.val);
        if(prev != null && prev.val >= root.val) //found breach
        {
            flag = false;
        }
        prev = root;
        //Console.WriteLine("prev = root "+root.val);
        //if(flag)
            helper(root.right);
        //Console.WriteLine("DOWN "+root.val);
          
    }
}


//BOOLEAN BASED APPROAHC WITH GLOBAL vairable PREV
public class Solution {
    TreeNode prev;
    
    public bool IsValidBST(TreeNode root) {
        
        return helper(root);
    }
    
    public bool helper(TreeNode root)
    {
        //base case
        if(root == null) return true;
        
        bool left = helper(root.left);
        Console.WriteLine("Up "+root.val);
        
        if(prev != null && prev.val >= root.val) //found breach
        {
            return false;
        }
        prev = root;
        
        Console.WriteLine("prev = root "+root.val);
        Console.WriteLine("DOWN "+root.val);
        
        return (left) && helper(root.right);
        
    }
}



///Validate BST = MIN and MAX approach - VOID based

public class Solution {
    bool flag;
    public bool IsValidBST(TreeNode root) {
        this.flag  = true;
        
        helper(root, null, null);
        return flag;
        
    }
    
    private void helper(TreeNode root, int? min, int? max)
    {
        //base case
        if(root == null) return;
       // if(!flag) return;
        
       
        if((min != null && root.val <= min) || (max != null && root.val >= max))
        {
            flag = false;
            return;
            
        }
      
         helper(root.left, min, root.val);
       
         helper(root.right, root.val, max);
        Console.WriteLine("Print   " );
    }
}


///Validate BST = MIN and MAX approach - Bool Based approach

public class Solution {
    bool flag;
    public bool IsValidBST(TreeNode root) {
        this.flag  = true;
        
        return  helper(root, null, null);
        
    }
    
    private bool helper(TreeNode root, int? min, int? max)
    {
        //base case
        if(root == null) return true;
       // if(!flag) return;
        
       
        if((min != null && root.val <= min) || (max != null && root.val >= max))
        {
             return false;
            
        }
      
         return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        
    }
}




///Void approach - Pass by REf, with passing an array of prev, so to maintain a local variable, but still gobally the same


public class Solution {
    bool flag;
    public bool IsValidBST(TreeNode root) {
        this.flag  = true;
        TreeNode[] prev = new TreeNode[1];
        
        helper(root, prev);
        return flag;
        
    }
    
    private void helper(TreeNode root,  TreeNode[] prev)
    {
        //base case
        if(root == null) return ;
        
        helper(root.left, prev);
        
        if(prev[0] != null && prev[0].val >= root.val)
        {
            flag = false;
            return;
        }
        prev[0] = root;
        
        helper(root.right, prev);
        
    }
}


//Iterative Approach

public class Solution {
    public bool IsValidBST(TreeNode root) {
        
        bool flag = true;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(stack.Count != 0 || root != null)
        {
            //left subtree
            while(root != null)
            {
                stack.Push(root);
                root = root.left;
            }
            root = stack.Pop();
            
            //pop from the stack and perform the check
            if(prev != null && prev.val >= root.val)
            {
                flag =false; 
                break;
            }
            prev = root;
            root = root.right;
        }
        return flag;
    }
}