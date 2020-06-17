import java.util.Stack;

class ValidBinarySearchTree{
    static TreeNode prev = null;
    static class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int a){
            val = a;
            left = null;
            right = null;
        }
    }
    public static boolean validate(TreeNode node){
//        recursive approach
//        if(node == null) return true;
//
//        if(validate(node.left) == false) return false;
//
//        if(prev != null && node.val <= prev.val) return false;
//        prev = node;
//
//        if(validate(node.right) == false) return false;
//
//        return true;
        //iterative approach
        Stack<TreeNode> stk = new Stack<>();

        while(node!=null || !stk.isEmpty()){
            while(node!=null){
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            if(prev != null && node.val <= prev.val) return false;
            prev = node;

            node = node.right;
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(validate(root));
    }

}