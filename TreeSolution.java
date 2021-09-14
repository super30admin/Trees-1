import java.util.HashMap;

public class TreeSolution {
    //Time complexity : N
    // space complexity : O(H)  H = height of tree
    // did it run on leetcode = yes
    // any doubts = no
    //98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/
static TreeNode Prev= null;
static Boolean result = true;
public boolean isValidBST(TreeNode root) {
    checkBST(root);
    return result;

}
private static void checkBST(TreeNode root){
    //base
    if(root == null){
        return;
    }
    //logic
    //preorder
    checkBST(root.left);
    //inorder
    // st.pop

    if(Prev != null && Prev.val >= root.val ){
        result =  false;
        return;
    }else{
        Prev = root;

    }
    checkBST(root.right);
    //postorder
    // st.pop
}
   //Time complexity : N
    // space complexity : N 
    // did it run on leetcode = yes
    // any doubts = no
//105. Construct Binary Tree from Preorder and Inorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
static HashMap<Integer,Integer> map;
static int idx =0;
public TreeNode buildTree(int[] preorder, int[] inorder) {
    
    map = new HashMap<>();
    for(int i =0;i<inorder.length;i++){
        map.put(inorder[i],i);        
    }
    return build(preorder,0,preorder.length-1);
}
private static TreeNode build(int[] preorder,int start,int end){
    //base
    if(start>end){
        return null;
    }
    //logic
    TreeNode root = new TreeNode(preorder[idx]);
    idx++;
    int index = map.get(root.val);
    root.left=build(preorder,start,index-1);
    root.right = build(preorder,index+1,end);
    return root;
}


}
