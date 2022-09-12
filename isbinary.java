/*Time Complexity: Asymptotically we are visiting each node twice O(N)
Space Complexity: O(N) for the worst case recursion storage
*/
class Solution {
ArrayList<Integer> a=new ArrayList<Integer>();
TreeNode previous=null;

boolean setter=true;
    void inorder(TreeNode root){
       
        if(root==null){
            return;
        }
         if(setter==false){
            return;
        }
        inorder(root.left);
        if(previous!=null && previous.val>=root.val){
            setter= false;
        }
        if(setter==false){
            return;
        }
        System.out.println(root.val);
        previous=root;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return setter;
    }
}