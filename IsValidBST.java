import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        //populate the list
        helper(root, inOrderList);
        boolean isBST=true;
        int prev = inOrderList.get(0);
        for(int i = 1; i < inOrderList.size(); i++){
            //check if element is smaller than previous element or if element is duplicate
            if(inOrderList.get(i)<= prev){
                isBST = false;
            }
            //updating prev element  
            prev = inOrderList.get(i);
        }
        return isBST;
    }

    void helper(TreeNode treeNode, List<Integer> inOrderList){
        if(treeNode==null){
            return;
        }
        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
    }
}

//TC: O(N)
//SC: O(N)
