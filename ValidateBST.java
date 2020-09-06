import java.util.*;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;

        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode node = root;
        List<Integer> list = new ArrayList();

        while(!stack.isEmpty() || node != null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                TreeNode n = stack.pop();

                if(list.size() >=1 && n.val <= list.get(list.size()-1)){
                    return false;
                }

                list.add(n.val);
                node = n.right;
            }
        }
        System.out.println(list);
        return true;
    }
}
