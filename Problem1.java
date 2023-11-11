// Time Complexity :  O(n)
// Space Complexity :  O(n+h)
// Did this code successfully run on Leetcode :  Yes

// Make an inorder traversal of the tree and store node values to a list.
//check if the list is in ascending order.


class Solution1 {

    private List<Integer> list;

    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
 

    public boolean isValidBST(TreeNode root) {

        list= new ArrayList<>();
        
        inOrder(root);

        for(int i=1; i<list.size(); i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}


// Time Complexity :  O(n)
// Space Complexity :  O(h)
// Did this code successfully run on Leetcode :  Yes

// Make an inorder traversal of the tree.
// store the inoreder predecessor value in a global variable.
// Compare it with the current node val.
// if lesser then go further and update global variable and move to next node. else return false;



class Solution2 {

    private long preVal;
    private boolean flag;

    private void inOrder(TreeNode root){
        
        if(root==null || !flag){
            return;
        }

        inOrder(root.left);

        if(root.val<=preVal){
            flag=false;
            return;
        }

        preVal=root.val;

        inOrder(root.right);
    }
 

    public boolean isValidBST(TreeNode root) {

        preVal= Long.MIN_VALUE;
        flag=true;
        inOrder(root);
        return flag;
    }
}

// Time Complexity :  O(n)
// Space Complexity :  O(h)
// Did this code successfully run on Leetcode :  Yes

// Different from solution2 in a way that we are not maintaining a global flag boolean
// instead we will validate left if ok go for curr and then if ok go right and return true if all are true else false;
// So we will call recursivelt at each node.




class Solution3 {

    private long preVal;

    private boolean check(TreeNode root){

        //base
        if(root==null){
            return true;
        }

        //left
        boolean left= check(root.left);

        if(left){
            //node
            boolean curr= root.val>preVal;
            preVal=root.val;

            if(curr){
                //right
                boolean right= check(root.right);
                return right;
            }
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {

        preVal= Long.MIN_VALUE;
        
        return check(root);
    }
}