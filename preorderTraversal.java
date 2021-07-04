/* ITERATIVE Solution */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        TreeNode traverse=root;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.addLast(traverse);
        
        while(stack.size()!=0)
        {
            traverse=stack.pollFirst();
            if(traverse!=null)
                result.add(traverse.val);
            
            if(traverse.right!=null)
                stack.addFirst(traverse.right);
            
            if(traverse.left!=null)
                stack.addFirst(traverse.left);

    }
        
        return result;
    }
}