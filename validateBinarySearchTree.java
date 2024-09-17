/** Time Complexity : O(n) where n is the number of nodes,we visit eaach node once
 * Space Complexity: O(n) we add n nodes into the stack
 * executed on leetcode: yes
 * approach: we initiate an empty stack and null treenode prev( used for validation)
 * 2. we propagate on the left subtree of the root and keep on adding root stack till we hit a null node
 * 3. we pop the stack and now we check if prev node value >= root value, in this case tree wont be a binary search tree
 * 4. now we ressign prev as root and propagate to the right subtree
 * 5. we continue this process till we get a false or our stacj is empty, if our stack becomes empty, we return true
 */



class validate {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode prev = null;
        while(!stack.isEmpty()||root!=null)
        {
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev=root;
            root = root.right;
        }
        return true;
    }
}