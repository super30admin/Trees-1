//Time Complexity : O(n), n is number of nodes
//Space Complexity : O(n)




class Solution { 
    public boolean isValidBST(TreeNode root) {
        //find inorder of the tree, if inorder is ascending then bst is valid
        TreeNode prev = null;
        //Initialize globally in recursive solution, as prev pointer should not be sent each time to the helper function, we will send val,null for first push to stack
        Stack<TreeNode> st = new Stack<>(); //use stack to check if left < root < right        
        while(root!= null || !st.empty()) { //if both true : no elements.
            //intitially only stack is empty and root is the first element (root of input)
            while(root!= null) {
                //do this till leaf (null)
                //push to stack only
                //for left side of each subtree
                st.push(root);
                root = root.left;            
            }
            //if we encounter a null
            //pop that last element, as it is left most element
            root = st.pop();
            //check if popped element is > than prev popped element 
            // if not return false, do not do this for first pop (prev is null then)
            if(prev != null && prev.val >= root.val) return false;
            //update prev
            prev = root; 
            //as left side is null, go to right side (new subtree)
            //we will again visit left of the right subtree (this becomes the root)
            root = root.right; 
        } return true;        
    }
}