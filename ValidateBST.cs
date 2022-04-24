// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//min and max approach, we store min and max at ever node
//compare with root.val
public bool IsValidBST(TreeNode root) {
    if(root == null)
        return true;
    
    return helper(root, null, null);
}

private bool helper(TreeNode root, int? min, int? max)
{
    //base condition
    if(root == null)
        return true;
    
    if(min >= root.val)
        return false;
    
    if(max <= root.val)
        return false;
    
    var case1 = helper(root.left, min, root.val);
    var case2 = helper(root.right, root.val, max);

    return case1 && case2;
}


//iterative approach using stack
//we compare the root value with left noe value, if its smaller, return false
//O(n), O(n)
public bool IsValidBST(TreeNode root) {
    if(root == null)
        return true;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    while(root != null || stack.count >0)
    {
        while(root != null)
        {
            stack.Push(root);
            root = root.left;
        }
        root = stack.Pop();
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;
        root = root.right;
    }
}


//recurson approach
//O(n)
//O(h) h is hegiht of tree
TreeNode prev = null;
bool isValid;
public bool IsValidBST(TreeNode root) {
    if(root == null)
        return true;

    isValid = false;
    inOrder(root);
    return isValid;
}

private bool inOrder(TreeNode root)
{
    //base condition
    if(root == null)
        return true;
    
    //logic
    if(inOrder(root.left) == false)
        return false;
    
    if(prev != null && prev.val >= root.val)
        return false;

    prev = root;
    return inOrder(root.right);

}