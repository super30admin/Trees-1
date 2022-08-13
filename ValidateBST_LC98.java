
class Solution {
    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        //if the inorder traversal of the tree is sorted it is a binary sub tree - 
        //do the inorder traversal and add the node in the result list then traverse the list and check if its sorted ascending order 
        //TC:O(n)
        //SC:O(n)
        helper(root);
        for(int i=1;i<res.size();i++){
            //System.out.print(res.get(i));
            if(res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
    }
    
    private  List<Integer> helper(TreeNode root){
        
        if(root==null){
            return res;
        }
        
        helper(root.left);
        res.add(root.val);
        helper(root.right);
        
        return res;
    
    }
    
}
 */

//Approach 2:
 //if the inorder traversal of the tree is sorted it is a binary sub tree - 
        //while doing inorder traversal check if prev node is lesser than current node
        
        //TC:O(n)
        //SC:O(1)

// class Solution {
//    TreeNode prev;
//     boolean flag;
//     public boolean isValidBST(TreeNode root) {
//         //set default value of prev and flag
//         prev = null;
//         flag = true;
//         helper(root);
//         return flag;
//     }
    
//     private void helper(TreeNode root){
        
//         if(root==null){
//             return;
//         }
        
//         helper(root.left);
//       //check if the prev node was less than curr node , if not set flag to false
//         if(prev!=null && prev.val>=root.val){
//             flag = false;
//         }
//         prev=root;
//         //if flag is true then check the right subtree -- can apply same for left rec call
//         if(flag){
//         helper(root.right);
//         }
    
//     }
    
// }

//Approach 3:
 //if the iterative inorder traversal of the tree is sorted it is a binary sub tree - 
        //while doing inorder traversal check if prev node is lesser than current node
        
        //TC:O(n)
        //SC:O(1)

class Solution {
    public boolean isValidBST(TreeNode root) {
       
        TreeNode prev=null;
        Stack<TreeNode> s = new Stack<>();
        while(root!=null ||!s.isEmpty()){
           while(root!=null){
               s.push(root);
               root = root.left;
           } 
            root = s.pop();
            if(prev!= null && prev.val>=root.val)
            {
                return false;
            } 
            prev=root;
            root = root.right;
                
            
        }
       return true; 
    }    
}