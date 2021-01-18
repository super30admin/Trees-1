
//Time complexity:O(n)
//Space Complexity:O(h)
public class Solution2 {
	public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
           root = st.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
           prev = root;
            root = root.right;
        }return true;
    }
}
