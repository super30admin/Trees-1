0(N),O(N)
//For BST always check if root is greater than left node and less than right node

public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean isBST(TreeNode root,long min,long max){
        if(root==null)return true;
        if(root.val<=min || root.val >= max) return false;
        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
            
    }


    