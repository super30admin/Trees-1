class InorderToBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    
    
    public int findInInorder(int data, int[] inorder){

        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == data)
                return i;
        }
        return -1;
    }

    static int preorderIndex=0;
    // int preorderIndex = 0;
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){

        if(inorderStart > inorderEnd)
            return null;
        
        // create node from preorder
        int data = preorder[preorderIndex];
        preorderIndex++;
        TreeNode newNode = new TreeNode(data);

        // no children
        if(inorderStart == inorderEnd) return newNode;
        
        //search in inorder to find index
        int inorderIndex = findInInorder(data, inorder);


        //node.left -> left side in inorder
        newNode.left = buildTreeHelper(preorder, inorder, inorderStart, inorderIndex-1);

        //node.right -> right side in inorder

        newNode.right = buildTreeHelper(preorder, inorder, inorderIndex+1, inorderEnd);

        return newNode;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
                
        TreeNode root = buildTreeHelper(preorder, inorder, 0, inorder.length-1);
        return root;
    }

    public void printInorderTraversal(TreeNode root){

        if(root == null) return;
        printInorderTraversal(root.left);
        System.out.print(root.val + " ");
        printInorderTraversal(root.right);

    }

    public static void main(String[] args){
        System.out.println("InorderToBST");
        InorderToBST obj = new InorderToBST();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = obj.buildTree(preorder, inorder);
        obj.printInorderTraversal(root);
    }
}