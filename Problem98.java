package problems.tree;

public class Problem98 {
    TreeNode prev;
    TreeNode prev1;
    boolean flag;
    boolean helperFlag;
    public boolean isValidBST(TreeNode root) {
        this.helperFlag=true;
        /*this.flag=true;
        inOrder1(root);
        if(flag)
            System.out.println("Valid BST for inorder");
        else
            System.out.println("In-Valid BST for inorder");*/
        helper(root,null,null);
        if(helperFlag)
            System.out.println("Valid BST");
        else
            System.out.println("In-Valid BST");
        return inOrder(root);
    }

    private void helper(TreeNode root, Integer low, Integer high) {
        //base condition
        if(!helperFlag)
            return;
        if(root==null)
            return;
        //logic
        System.out.println(root.val);

        if((low!=null && low>= root.val) || (high!=null && high<=root.val)){
            helperFlag=false;
            return;
        }
        helper(root.left,low, root.val);
        helper(root.right, root.val, high);
    }

    private boolean inOrder(TreeNode root){
        if(root==null)
            return true;
        System.out.println(root.val);

        if(inOrder(root.left)==false){
            return false;
        }
        if(prev!=null && prev.val>=root.val)
            return false;
        prev=root;
        return inOrder(root.right);
    }

    private void inOrder1(TreeNode root){
        if(!flag)
            return;
        if(root==null)
            return;
        System.out.println(root.val);

        inOrder1(root.left);
        if(prev1!=null && prev1.val>=root.val) {
            flag = false;
            return;
        }
        prev1=root;
        inOrder1(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(150);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(80);
        root.right.left = new TreeNode(120);
        root.right.right = new TreeNode(180);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(60);
        root.left.right.right = new TreeNode(75);
        root.right.left.left = new TreeNode(110);
        root.right.left.right = new TreeNode(140);
        root.right.right.left = new TreeNode(160);
        root.right.right.right = new TreeNode(200);
        Problem98 problem=new Problem98();
        System.out.println(problem.isValidBST(root));
    }
}
