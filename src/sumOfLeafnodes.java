public class sumOfLeafnodes{
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    
    public void helper( TreeNode root, int num){
        
        if( root == null){
            return;
        }
        
        num = num*10+ root.val;
        if( root.left == null && root.right == null){
            sum += num;
        }
        
        helper(root.left, num);
        helper(root.right, num);
        
    }
}