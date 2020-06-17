//https://leetcode.com/problems/validate-binary-search-tree/
// Time Complexity : O(n) 
// Space Complexity : O(h) where h is the height ( no of elements possible in recursive stack at a point)
// Did this code successfully run on Leetcode : Yes


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
    public boolean isValidBST(TreeNode root) {
        //we do inorder traversal and keep validating
        
        Stack<TreeNode> stack = new Stack<>(); // equivalent recursive stack
        TreeNode prev = null; // to keep track of previous node
        
        while(root!=null || !stack.isEmpty()) // if we have elements in stack or root is there
        {
            while(root!=null) // till we dont find null
            {
                stack.push(root); // push root to stack
                root = root.left; // go left
            }
            root = stack.pop(); // pop out the top most element of the stack and assign it as root
            if(prev!=null && prev.val >= root.val) // if prev != null (i.e not first node on left as we have no prev for it) and prev value is greater than root
                return false; // invalid bst
            prev = root; // assign the current root as prev
            root = root.right; // when left traversed go to the right
        }
        
      return true;  
    }
}

// Time Complexity : O(n) 
// Space Complexity : O(n) for hashmap, h not included as tree is returned as result (output data structure)
// Did this code successfully run on Leetcode : Yes

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        
       return inorder(root);

    }
    
    private boolean inorder(TreeNode root)
    {   
         //base
            if(root == null) // when we reach the null node
                return true; // valid branch
         
           if( inorder(root.left) == false) // traversing the root's left till we hit base condition
           // if we find a invalid left subtree
               return false; // return false
        
            if(prev!=null && prev.val >= root.val) // if prev != null (i.e not first node on left as we have no prev for it) and prev value is greater than root
                return false; // invalid bst
            prev = root; // assign the current root as prev
        
          return inorder(root.right); // call inorder on right when left has been traversed fully for the root
        
        }
    
}

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Time Complexity : O(n*n) = O(n^2) as for n node search o(n) is done
// Space Complexity : O(h) where h is the height ( no of elements possible in recursive stack at a point)
// Did this code successfully run on Leetcode : Yes


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      //edge case  
        if(preorder.length==0 || inorder.length==0) // if no elements
            return null;
        
        TreeNode root = new TreeNode(preorder[0]); // taking first element of preorder as root
        
        int index =-1; // to track root in inorder
       
        //searching for root in inorder
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i] == root.val)
                index = i; // storing root index
        }
        
        // creating arrays of left and right for both inorder and postorder by reducing range each time based on the root 
        int preLeft[] = Arrays.copyOfRange(preorder, 1, index+1); 
        int preRight[] = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int inLeft[] = Arrays.copyOfRange(inorder, 0, index);
         int inRight[] = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        //adding nodes by calling build tree on root left
        root.left = buildTree(preLeft,inLeft);
        
         //adding nodes by calling build tree on root left
        root.right = buildTree(preRight,inRight);
        
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height ( no of elements possible in recursive stack at a point)
// Did this code successfully run on Leetcode : Yes

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
    HashMap<Integer, Integer> map; // to store inorder values and their index
    int index; // to traverse the preorder array , 0 by default
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) // adding values to the hashmap
        {
            map.put(inorder[i], i);
        }
       
       return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        //base
        if(start> end || index == preorder.length) // when the range gets over i.e we have a leaf node or all elements have been traversed
            return null;
        
        //logic
        TreeNode root = new TreeNode(preorder[index]); // using preorder we create the root starting at 0
        index++; // next value will give left values and then right
        
        int inIndex = map.get(root.val); // getting the index of root in inorder

        //creating the left subtree of node
        root.left = helper(preorder, inorder, start, inIndex-1); 
         //creating the right subtree of node
        root.right = helper(preorder, inorder, inIndex+1, end);
        
        return root;
    }
}