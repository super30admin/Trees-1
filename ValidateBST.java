// Time Complexity : O(n), since we visit all nodes atmost
// Space Complexity : O(n), in worst case if tree has all leftnodes or rightnodes, else on average I think this would be log n

// Your code here along with comments explaining your approach
// this is the iterative version of inorder traversal using a stack

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int prevVal = -1;
        
        while(root!=null || !stack.isEmpty()){
            //add all left nodes to stack
            while(root!=null){
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();

            if(prevVal!=-1 && prevVal>=root.val) return false;
    
            prevVal = root.val;
            
            root = root.right;
        }
        
        return true;
    }
}

// Time Complexity : O(n), since we visit all nodes and then check if sorted
// Space Complexity : O(n) + O(log n), for the arraylist to store all elements and O(log n) for the stack space  

// Your code here along with comments explaining your approach
//Do inorder traversal of the input tree, store elements in an arraylist, check if it is sorted

class Solution {
    static ArrayList<Integer> inorderTraversal = new ArrayList<Integer>();
    
    private static void inorder(TreeNode root){
        if(root.left!=null){
            inorder(root.left);
        }
        
        inorderTraversal.add(root.val);
        
        if(root.right!=null){
            inorder(root.right);
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return  true;
        }
        
        inorder(root);
        
        for(int i=1; i<inorderTraversal.size();i++){
            if(inorderTraversal.get(i)<inorderTraversal.get(i-1)){
                return false;
            }
        }
        
        return true;
    }
}